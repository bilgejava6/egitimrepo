package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GenelMudurController {
    PersonelService personelService = new PersonelService();
    Scanner sc;
    GenelMudur genelMudur;

    public void save() {
        sc = new Scanner(System.in);
        genelMudur = new GenelMudur();
        System.out.println("Genel Müdür Kayıt ediyorusunuz..");

        System.out.println("Genel Mudurun adı ve soyadı..: ");
        genelMudur.setIsim(sc.nextLine());

        System.out.println("Genel Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        genelMudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Genel müdürün yaşı..: ");
        genelMudur.setYas(sc.nextInt());

        System.out.println("Genel müdürün maaşı..: ");
        genelMudur.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Sorumlu olduklarıyla ilgili görev tanımı ");
        genelMudur.setGorevTanimi(sc.nextLine());

        System.out.println("Genel müdürün işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        // SimpleDateFormat tarihFormati = new SimpleDateFormat("dd/MM/yyyy");
        // tarihFormati.parse()
        // Date date = new Date();
        genelMudur.setIseBaslamaTarihi(yil - 1900, ay - 1, gun);


        // genel mudurun sorumlu oldugu departmanları atamak
        System.out.println("Genel Müdürün sorumlu olduğu departmanı giriniz.");
        var value = 1;
        var departmanSahiplikSayisi = 1;
        do {
            switch (value) {
                case 1:
                    for (Departman departman : StaticValues.departmanListesi) {
                        System.out.println(StaticValues.departmanListesi.indexOf(departman) + 1 + " -> " + departman.getAd());
                    }
                    int secim2 = sc.nextInt();
                    genelMudur.getGenelMudurlerinSorumluOlduguDepartmanListesi().add(StaticValues.departmanListesi.get(secim2 - 1));
                    break;
                case 0:
                    System.out.println("Cıkıs Yapiliyor");
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız");
            }
            departmanSahiplikSayisi++;
            System.out.println("[1] -> " + departmanSahiplikSayisi + ". departmanı ekle");
            System.out.println("[0] -> Departman atama işleminden çık ve genel mudurun bilgilerini oluşturmaya devam et");
            value = sc.nextInt();
        } while (value != 0);
        StaticValues.mapGenelMudurDepartmanListesi.put(genelMudur, genelMudur.getGenelMudurlerinSorumluOlduguDepartmanListesi());

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for (Departman departman : StaticValues.departmanListesi) {
            System.out.println(index + " -> " + departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        genelMudur.setDepartman(StaticValues.departmanListesi.get(secim - 1));
        genelMudur.getDepartman().getDepartmanPersonelListesi().add(genelMudur);
        personelService.save(genelMudur);
    }

    public void update() {
        genelMudur = new GenelMudur();
        sc = new Scanner(System.in);

        // System.out.println("Genel Müdürler listeleniyor..: ");
        // Genel müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        genelMudur.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Genel Mudurun adı ve soyadı..: ");
        genelMudur.setIsim(sc.nextLine());

        System.out.println("Genel Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        genelMudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Genel müdürün yaşı..: ");
        genelMudur.setYas(sc.nextInt());

        System.out.println("Genel müdürün maaşı..: ");
        genelMudur.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Sorumlu olduklarıyla ilgili görev tanımı ");
        genelMudur.setGorevTanimi(sc.nextLine());

        System.out.println("Genel müdürün işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        genelMudur.setIseBaslamaTarihi(yil - 1900, ay - 1, gun);

        // genel mudurun sorumlu oldugu departmanları atamak
        System.out.println("Genel Müdürün sorumlu olduğu departmanı giriniz.");
        var value = 1;
        var departmanSahiplikSayisi = 1;
        do {
            switch (value) {
                case 1:
                    for (Departman departman : StaticValues.departmanListesi) {
                        System.out.println(StaticValues.departmanListesi.indexOf(departman) + 1 + " -> " + departman.getAd());
                    }
                    int secim2 = sc.nextInt();
                    genelMudur.getGenelMudurlerinSorumluOlduguDepartmanListesi().add(StaticValues.departmanListesi.get(secim2 - 1));
                    break;
                case 0:
                    System.out.println("Cıkıs Yapiliyor");
                    break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız");
            }
            departmanSahiplikSayisi++;
            System.out.println("[1] -> " + departmanSahiplikSayisi + ". departmanı ekle");
            System.out.println("[0] -> Departman atama işleminden çık ve genel mudurun bilgilerini oluşturmaya devam et");
            value = sc.nextInt();
        } while (value != 0);
        StaticValues.mapGenelMudurDepartmanListesi.put(genelMudur, genelMudur.getGenelMudurlerinSorumluOlduguDepartmanListesi());

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for (Departman departman : StaticValues.departmanListesi) {
            System.out.println(index + " -> " + departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        genelMudur.setDepartman(StaticValues.departmanListesi.get(secim - 1));

        genelMudur.getDepartman().getDepartmanPersonelListesi().add(genelMudur);
        System.out.println("Personel başarı ile eklendi..");

        personelService.update(genelMudur);
    }
}
