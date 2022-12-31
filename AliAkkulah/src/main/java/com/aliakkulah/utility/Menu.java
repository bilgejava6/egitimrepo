package com.aliakkulah.utility;

import com.aliakkulah.controller.DepartmanController;
import com.aliakkulah.controller.PersonelController;

import java.util.Scanner;

public class Menu {
    private static Scanner sc;
    private final PersonelController pc;
    private final DepartmanController dc;

    public Menu() {
        this.pc = new PersonelController();
        this.dc = new DepartmanController();
    }

    public void runAna() {
        sc = new Scanner(System.in);
        int secim = 0;
        int secim2 = 0;
        do {
            System.out.println("*******   ANA MENU   *******");
            System.out.println("1. Personel Islemleri");
            System.out.println("2. Muhasebe Islemleri");
            System.out.println("3- Raporlamalar");
            System.out.println("0- CIKIS");
            System.out.println("Secim yapiniz.");
            secim = sc.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("*******   Personel Islemleri   *******");
                    System.out.println("1. Personel Ekleme"); //yapıldı.
                    System.out.println("2. Personel Listesi"); //yapıldı.
                    System.out.println("3. Personel Duzenleme");
                    System.out.println("4. Departman Ekleme"); //yapıldı.
                    System.out.println("5. Departman Listesi"); //yapıldı.
                    System.out.println("6. Personel Sil"); //yapıldı.
                    System.out.println("7. Id'ye Gore Personel Sil"); //yapıldı.
                    System.out.println("8. Id'ye Gore Personel Bul"); //yapıldı.
                    System.out.println("9. Mudure Sorumlu Oldugu Departmani Ekle"); //yapıldı.
                    System.out.println("0. Ana Menuye Don"); //yapıldı.
                    System.out.println("Secim yapiniz.");
                    secim2 = sc.nextInt();
                    switch (secim2){
                        case 1:
                            System.out.println("1. Buro Personeli");
                            System.out.println("2. Genel Mudur");
                            System.out.println("3. Hizmetli");
                            System.out.println("4. Insan Kayanklari");
                            System.out.println("5. Mudur");
                            System.out.println("6. Muhasebe");
                            System.out.println("7. Teknik");
                            System.out.println("Eklemek istediginiz personel tipini seciniz");
                            pc.eklenecekPersonelTipiSecme(sc.nextInt());
                            break;
                        case 2:
                            pc.findAll();
                            break;
                        case 3:
                            pc.update();
                            break;
                        case 4:
                            dc.departmanEkle();
                            break;
                        case 5:
                            dc.findAll();
                            break;
                        case 6:
                            pc.delete();
                            break;
                        case 7:
                            pc.deleteById();
                            break;
                        case 8:
                            pc.findById();
                            break;
                        case 9:
                            pc.mudureSorumluOlduguDepartmanEkle();
                            break;
                        case 0: break;
                        default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                            break;
                    }   break;
                case 2:
                    System.out.println("*******   Muhasebe Islemleri   *******");
                    System.out.println("1 Maas Personel Tanimlama"); //yapıldı.
                    System.out.println("2 Odeme Listesi"); //yapıldı.
                    System.out.println("0. Ana Menuye Don"); //yapıldı.
                    System.out.println("Secim yapiniz.");
                    secim2 = sc.nextInt();
                    switch (secim2){
                        case 1: pc.maasTanimla(Utility.personelListesi.get(10));
                            break;
                        case 2: pc.odemeListesi(Utility.personelListesi.get(10));
                            break;
                        case 0: break;
                        default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                            break;
                    }   break;
                case 3:
                    System.out.println("*******   Raporlamalar   *******");
                    System.out.println("1 Departman Personel Listesi"); //yapıldı.
                    System.out.println("2 En Cok Personel Bulunan Departman"); //yapıldı.
                    System.out.println("3 Departmanlara Gore Maas Ortalamalari"); //yapıldı.
                    System.out.println("4 Mudurlerin Sorumlu Oldugu Departman Listesi"); //yapıldı.
                    System.out.println("5 Kayit Tarihlerine Gore Personellerin Sirali Listesi"); //yapıldı.
                    System.out.println("6 Ayni Gun Icinde Ise Baslayan Personellerin Listesi"); //yapıldı.
                    System.out.println("0. Ana Menuye Don");
                    System.out.println("Secim yapiniz.");
                    secim2 = sc.nextInt();
                    switch (secim2){
                        case 1:
                            System.out.println("Istediginiz departman id sini giriniz.");
                            Utility.departmanListesi.forEach(x->{
                                System.out.println("id: " + x.getId() + " departman: " + x.getAd());
                            });
                            int id = sc.nextInt();
                            dc.departmanPersonelListesi(id);
                            break;
                        case 2:
                            dc.enCokPersonelliDepartman();
                            break;
                        case 3:
                            dc.departmanaGoreMaasOrtalamalari();
                            break;
                        case 4:
                            pc.mudurlerinSorumluOlduguDepartmanlar();
                            break;
                        case 5:
                            pc.siraliPersonelListesi();
                            break;
                        case 6:
                            pc.ayniGunBaslayanlarListesi();
                            break;
                        case 0: break;
                        default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                            break;
                    }   break;
                case 0:
                    secim = 0;
                    break;
                default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                    break;
            }
        }while(secim!=0);
    }
}