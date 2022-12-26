package com.emreustun.menu;

import com.emreustun.controller.DepartmanController;
import com.emreustun.controller.PersonelController;
import com.emreustun.entity.Departman;

import java.util.Scanner;

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
                    System.out.println("Çıkış yapılıyor");
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
                    System.out.println("Çıkış yapılıyor");
                    break;
                default:
                    System.out.println("Hatali tuşlama yaptınız");
                    break;
            }
        } while (secim != 0);
    }
}
