package com.volkangenel.odev.controller;

import com.volkangenel.odev.repository.entity.*;
import com.volkangenel.odev.service.PersonelService;

import com.volkangenel.odev.repository.entity.utility.StaticValues;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonelController {
    Scanner sc;
    PersonelService personelService;
    Personel personel;
    public PersonelController() {
       this.sc = new Scanner(System.in);
       this.personelService = new PersonelService();
    }

    public void save() {
        int secenek = 0;
        do {
            System.out.println("***** Personel İşlemleri *****");
            System.out.println("0- Ana Menüye Dön");
            System.out.println("1- Büro Personeli Ekleme");
            System.out.println("2- Genel Müdür Ekleme");
            System.out.println("3- Hizmetli Ekleme");
            System.out.println("4- İnsan Kaynakaları Ekleme");
            System.out.println("5- Müdür Ekleme");
            System.out.println("6- Muhasebe Personeli Ekleme");
            System.out.println("7- Teknik Personel Ekleme");
            System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz");
            secenek = sc.nextInt();
            System.out.println("Lütfen Personel Adı Giriniz...:");
            String ad = sc.nextLine();
            System.out.println("Lütfen Personel Soyadı Giriniz...:");
            String soyisim = sc.nextLine();
            System.out.println("Lütfen Personel Ünvan Giriniz...:");
            String unvan = sc.nextLine();
            System.out.println("Lütfen Personel Maas Giriniz...:");
            double maas = Double.parseDouble(sc.nextLine());
            System.out.println("Lütfen Personel Telefon Giriniz...:");
            String telefon = sc.nextLine();
            System.out.println("Lütfen Personel Acil Telefon Giriniz...:");
            String aciltelefon = sc.nextLine();
            System.out.println("Lütfen Personel TC Kimlik No Giriniz...:");
            String tckimlik = sc.nextLine();
            System.out.println("Lütfen Personel Departmanı No Giriniz...:");
            int departmanid = Integer.parseInt(sc.nextLine());
            switch (secenek) {
                case 0: System.out.println("Ana Menüye Dönülüyor");break;
                case 1:
                    System.out.println("Lütfen Büro Personeli Solitaire Skoru Giriniz:");
                    int solitaireSkoru = Integer.parseInt(sc.nextLine());
                    personel = new BuroPersoneli(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),solitaireSkoru);
                    personelService.save(personel);
                    break;
                case 2: System.out.println("Lütfen Genel Müdür Şirket Hisse Payi Giriniz:");
                    int sirketHissePayi = Integer.parseInt(sc.nextLine());
                    personel = new GenelMudur(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),sirketHissePayi);
                    personelService.save(personel);
                    break;
                case 3: System.out.println("Lütfen Hizmetli temizlik alanlarını Giriniz:");
                    String temizlikAlani1 = sc.nextLine();
                    String temizlikAlani2 = sc.nextLine();
                    String[] temizlikalani = new String[] {temizlikAlani1,temizlikAlani2};
                    personel = new Hizmetli(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),temizlikalani);
                    personelService.save(personel);
                    break;
                case 4: System.out.println("Lütfen İnsan Kaynakları Mulakat Sayısı Giriniz:");
                    int mulakatSayisi = Integer.parseInt(sc.nextLine());
                    personel = new InsanKaynaklariPersoneli(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),mulakatSayisi);
                    personelService.save(personel);
                    break;
                case 5:
                    System.out.println("Lütfen Müdür Maaşı Ek Ödeme Giriniz:");
                    int maasEkOdeme= Integer.parseInt(sc.nextLine());
                    List <String> gorevalalanlari = new ArrayList<>();
                        String choice=null;
                    System.out.println("Lütfen Müdür Görev Alanlarını Giriniz");

                    while (!choice.equals(0)) {
                            System.out.println("Ekleme işlemi bittiyse '0' a basınız.");
                            choice = sc.nextLine();
                            gorevalalanlari.add(choice);
                        }
                    List <String> baglipersoneller = new ArrayList<>();
                    choice=null;
                    System.out.println("Lütfen Müdür'e Bağlı Personelleri Giriniz");
                    while (!choice.equals(0)) {
                        System.out.println("Ekleme işlemi bittiyse '0' a basınız.");
                        choice = sc.nextLine();
                        baglipersoneller.add(choice);
                    }
                    personel = new Mudur(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),maasEkOdeme,gorevalalanlari,baglipersoneller);
                    personelService.save(personel);
                    break;
                case 6: System.out.println("Lütfen Muhasebe Personeli Sorumluluk Alanını Giriniz:");
                    String sorumlulukAlani = sc.nextLine();
                    personel = new MuhasebePersoneli(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),sorumlulukAlani);
                    personelService.save(personel);
                    break;
                case 7: System.out.println("Lütfen Teknik Personel Teknik Kolu No Giriniz:");
                    int teknikkoluno = Integer.parseInt(sc.nextLine());
                    System.out.println("Lütfen Teknik Personel Tesis No Giriniz:");
                    String tesisNo = sc.nextLine();
                    personel = new TeknikPersonel(ad,soyisim,unvan,maas,telefon,aciltelefon,tckimlik,StaticValues.departmanListesi.get(departmanid-1),teknikkoluno,tesisNo);
                    personelService.save(personel);
                    break;
                default: System.out.println("Hatalı Giriş Yaptınız"); break;
            }
        } while (secenek!=0);

    }
    public void update() {
    deleteById();
    save();
    }
    public void findAll() {
        System.out.println(personelService.findAll());
    }
    public void findById() {
        sc= new Scanner(System.in);
        Long id = Long.parseLong(sc.nextLine());
        System.out.println(personelService.findById(id));
    }
    public void deleteById() {
        sc= new Scanner(System.in);
        Long id = Long.parseLong(sc.nextLine());
        personelService.deleteById(id);
    }
}
