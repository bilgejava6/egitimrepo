package com.emreustun.menu;

import com.emreustun.controller.DepartmanController;
import com.emreustun.controller.PersonelController;
import com.emreustun.entity.Departman;
import com.emreustun.entity.Personel;
import com.emreustun.utility.StaticValues;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Menu {
    Scanner sc = new Scanner(System.in);
    PersonelController personelController = new PersonelController();
    DepartmanController departmanController = new DepartmanController();

    public void run() {
        System.out.println("******************************************");
        System.out.println("********* PERSONEL TAKİP SİSTEMİ ********");
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("1-> Personel İşlemleri");
        System.out.println("2-> Muhasebe İşlemleri");
        System.out.println("3-> Raporlamalar");
        System.out.println("0-> Çıkış");
        System.out.println();
        System.out.println("Lütfen seçiminizi yapınız");
        int secim = 0;
        do {
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    personelIslemleri();
                    break;
                case 2:
                    muhasebeIslemleri();
                    break;
                case 3:
                    raporlama();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor");
                    break;
                default:
                    System.out.println("Hatali tuşlama yaptınız");
                    break;
            }

        } while (secim != 0);
    }

    private void raporlama() {
        System.out.println("***************************************");
        System.out.println("********** RAPORLAMA İSLEMLERİ *********");
        System.out.println("****************************************");
        System.out.println();
        System.out.println("1-> Departman personel listesi");
        System.out.println("2-> En çok personel bulunan departman");
        System.out.println("3-> Departmanlara göre maaş ortalamaları");
        System.out.println("4-> Müdürlerin sorumlu olduğu departman listesi");
        System.out.println("5-> Kayıt tarihlerine göre personellerin sıralı listesi");
        System.out.println("0-> Bir önceki menüye dön");
        System.out.println();
        System.out.println("Lütfen seçiminizi yapınız");
        int secim = 0;
        do {
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    Map<Personel, List<Departman>> group = StaticValues.departmanListesi.stream().collect(Collectors.groupingBy(Departman::getPersonel));
                    group.forEach((k,v) -> System.out.println(k +" -> "+ v));
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Bir önceki menüye dönülüyor");
                    run();
                    break;
                default:
                    System.out.println("Hatali tuşlama yaptınız");
                    break;
            }
        } while (secim != 0);
    }

    private void muhasebeIslemleri() {
        System.out.println("******************************************");
        System.out.println("*********** MUHASEBE ISLEMLERİ ***********");
        System.out.println("******************************************");
        System.out.println();
        System.out.println("1-> Maaş Personel Tanımlama");
        System.out.println("2-> Ödeme Listesi");
        System.out.println("0-> Bir önceki menüye dön");
        System.out.println();
        System.out.println("Lütfen seçiminizi yapınız");
        int secim = 0;
        do {
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    personelController.maasPersonelTanimlama();
                    break;
                case 2:
                    personelController.odemeListesi();
                    break;
                case 0:
                    System.out.println("Bir önceki menüye dönülüyor");
                    run();
                    break;
                default:
                    System.out.println("Hatali tuşlama yaptınız");
                    break;
            }

        } while (secim != 0);
    }

    private void personelIslemleri() {
        System.out.println("***************************************");
        System.out.println("********** PERSONEL ISLEMLERI *********");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("1-> Personel Ekleme");
        System.out.println("2-> Personel Listesi");
        System.out.println("3-> Personel Düzenleme");
        System.out.println("4-> Departman Ekleme");
        System.out.println("5-> Departman Listesi");
        System.out.println("0-> Bir önceki menüye dön");
        System.out.println();
        System.out.println("Lütfen seçiminizi yapınız");
        int secim = 0;
        do {
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    personelController.save();
                    break;
                case 2:
                    personelController.findAll();
                    break;
                case 3:
                    personelController.update();
                    break;
                case 4:
                    departmanController.save();
                    break;
                case 5:
                    departmanController.findAll();
                    break;
                case 0:
                    System.out.println("Bir önceki menüye dönülüyor");
                    run();
                    break;
                default:
                    System.out.println("Hatali tuşlama yaptınız");
                    break;
            }
        } while (secim != 0);
    }
}
