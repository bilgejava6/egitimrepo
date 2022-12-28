package com.yavuzavci.utility.menu;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.Personel;

import java.util.*;
import java.util.stream.Collectors;

import static com.yavuzavci.utility.StaticValues.*;

public class RaporlamaMenu extends AnaMenu {
    private void raporlamaMenuBaslik() {
        System.out.println("*************************************************************");
        System.out.println("******************* RAPORLAMA İŞLEMLERİ *********************");
        System.out.println("*************************************************************");
        System.out.println("1 -> Departman Personel Listesi");
        System.out.println("2 -> En Çok Personel Bulunan Departman");
        System.out.println("3 -> Departmanlara Göre Maaş Ortalamaları");
        System.out.println("4 -> Müdürlerin Sorumlu Olduğu Departman Listesi");
        System.out.println("5 -> Kayıt Tarihlerine Göre Persollerin Sıralı Listesi");
        System.out.println("6 -> Aynı Gün İçinde İşe Başlayan Personellerin Listesi");
        System.out.println("0 -> Ana Menüye Dön");
    }

    @Override
    public void menu() {
        int secim = 0;
        do {
            raporlamaMenuBaslik();
            System.out.print("Lütfen seçiminizi yapınız...: ");
            secim = scanner.nextInt();
            scanner.nextLine();
            islemSec(secim);
        } while (secim != 0);
        anaMenu.menu();
    }

    @Override
    public void islemSec(int secim) {
        switch (secim) {
            case 1:
                if (personelController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (departmanController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                for (Departman departman : departmanController.findAll()) {
                    if (departman.getPersonelListesi().isEmpty())
                        continue;
                    System.out.println("Departman: " + departman.getAd());
                    departman.getPersonelListesi().forEach(System.out::println);
                }
                break;
            case 2:
                if (personelController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (departmanController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                String ad = departmanController.findAll()
                        .stream()
                        .collect(Collectors.toMap(
                                Departman::getAd,
                                d -> d.getPersonelListesi().size()))
                        .entrySet().stream()
                        .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                        .get()
                        .getKey();
                System.out.println("En çok personel bulunan departman : " + ad);
                break;
            case 3:
                if (personelController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (departmanController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                departmanController.findAll().stream()
                        .collect(
                                Collectors.toMap(
                                        Departman::getAd,
                                        d -> d.getPersonelListesi()
                                                .stream()
                                                .collect(Collectors.averagingInt(Personel::getYas))
                                )
                        )
                        .forEach((k, v) ->
                                System.out.println("Departman -> " + k + " | Maaş Ortalaması -> " + v + " TL")
                        );
                break;
            case 4:
                if (personelController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (departmanController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                break;
            case 5:
                if (personelController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.println("## Kayıt tarihine göre personeller ##");
                personelController.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Personel::getCreateDate))
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
            case 6:
                if (personelController.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                // (Personel p1, Personel p2) -> p1.getCreateDate().equals(p2.getCreateDate())
                System.out.println("## Aynı gün işe başlayan personeller ##");
                personelController.findAll()
                        .stream()
                        .filter(p ->
                                Collections.frequency(personelController.findAll(),p.getCreateDate()) > 1)
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
            case 0:
                break;
            default:
                System.err.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
