package com.yavuzavci.utility.menu;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.Mudur;
import com.yavuzavci.entity.Personel;

import java.util.*;
import java.util.stream.Collectors;

import static com.yavuzavci.utility.StaticValues.*;

/**
 * Raporlamalar için kullanılan menü.
 * @author Yavuz AVCI
 */
public class RaporlamaMenu implements IMenu {
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
            secim = SCANNER.nextInt();
            SCANNER.nextLine();
            islemSec(secim);
        } while (secim != 0);
        ANA_MENU.menu();
    }

    @Override
    public void islemSec(int secim) {
        switch (secim) {
            case 1:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (DEPARTMAN_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                for (Departman departman : DEPARTMAN_CONTROLLER.findAll()) {
                    if (departman.getPersonelListesi().isEmpty())
                        continue;
                    System.out.println("Departman: " + departman.getAd());
                    departman.getPersonelListesi().forEach(System.out::println);
                }
                break;
            case 2:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (DEPARTMAN_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                String ad = DEPARTMAN_CONTROLLER.findAll()
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
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (DEPARTMAN_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                DEPARTMAN_CONTROLLER.findAll().stream()
                        .collect(
                                Collectors.toMap(
                                        Departman::getAd,
                                        d -> d.getPersonelListesi()
                                                .stream()
                                                .collect(Collectors.averagingDouble(Personel::getMaas))
                                )
                        )
                        .forEach((k, v) ->
                                System.out.println("Departman -> " + k + " | Maaş Ortalaması -> " + v + " TL")
                        );
                break;
            case 4:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                if (DEPARTMAN_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı departman yoktur.");
                    break;
                }
                if (PERSONEL_CONTROLLER.findAll()
                        .stream()
                        .filter(Mudur.class::isInstance)
                        .map(Mudur.class::cast)
                        .toList()
                        .isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı müdür veya genel müdür yoktur.");
                }
                System.out.println("## Müdürler ve sorumlu olduğu departmanlar ##");
                PERSONEL_CONTROLLER.findAll()
                        .stream()
                        .filter(Mudur.class::isInstance)
                        .map(Mudur.class::cast)
                        .toList()
                        .forEach(m -> {
                            System.out.println(m.getClass().getSimpleName() +  " - " + m.getAdSoyad());
                            System.out.println("Sorumlu olduğu departmanlar");
                            m.getDepartmanlar().forEach(System.out::println);
                        });
                break;
            case 5:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.println("## Kayıt tarihine göre personeller ##");
                PERSONEL_CONTROLLER.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Personel::getCreateDate))
                        .toList()
                        .forEach(System.out::println);
                break;
            case 6:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("Bilgi: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                // (Personel p1, Personel p2) -> p1.getCreateDate().equals(p2.getCreateDate())
                System.out.println("## Aynı gün işe başlayan personeller ##");
                PERSONEL_CONTROLLER.findAll()
                        .stream()
                        .filter(p ->
                                Collections.frequency(PERSONEL_CONTROLLER.findAll(),p.getCreateDate()) > 1)
                        .toList()
                        .forEach(System.out::println);
                break;
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
