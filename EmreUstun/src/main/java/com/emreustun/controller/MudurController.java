package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.Mudur;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;
import java.util.Scanner;

public class MudurController {
    PersonelService personelService = new PersonelService();
    Scanner sc;
    Mudur mudur;
    public void save() {
        sc = new Scanner(System.in);
        mudur = new Mudur();
        System.out.println("Müdür Kayıt ediyorusunuz..");

        System.out.println("Müdürün adı ve soyadı..: ");
        mudur.setIsim(sc.nextLine());

        System.out.println("Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        mudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Müdürün yaşı..: ");
        mudur.setYas(sc.nextInt());

        System.out.println("Müdürün maaşı..: ");
        mudur.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Müdürün görev tanımını giriniz..: ");
        mudur.setGorevTanimi(sc.nextLine());

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        mudur.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        //mudurun sorumlu oldugu departmanları atamak
        System.out.println("Müdürün sorumlu olduğu departmanı giriniz.");
        var value = 1;
        var departmanSahiplikSayisi = 1;
        do{
            switch (value) {
                case 1:
                    int index2 = 1;
                    for (Departman departman : StaticValues.departmanListesi) {
                        System.out.println(index2 + " -> " + departman.getAd());
                        index2++;
                    }
                    int secim2 = sc.nextInt();
                    mudur.getMudurlerinSorumluOlduguDepartmanListesi().add(StaticValues.departmanListesi.get(secim2 - 1));
                    break;
                case 0:
                    System.out.println("Cıkıs Yapiliyor");
                    break;
            }
            departmanSahiplikSayisi++;
            System.out.println("[1] -> "+departmanSahiplikSayisi+". departmanı ekle");
            System.out.println("[0] -> Departman atama işleminden çık ve mudurun bilgilerini oluşturmaya devam et");
            value = sc.nextInt();
        }while(value != 0);
        // stat values da mapin içine atıyoruz
        StaticValues.mapMudurDepartmanListesi.put(mudur,mudur.getMudurlerinSorumluOlduguDepartmanListesi());
        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        mudur.setDepartman(StaticValues.departmanListesi.get(secim-1));


        mudur.getDepartman().getDepartmanPersonelListesi().add(mudur);

        personelService.save(mudur);
    }

    public void update() {
        mudur = new Mudur();
        sc = new Scanner(System.in);

        // System.out.println("Müdürler listeleniyor..: ");
        // müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        mudur.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Mudurun adı ve soyadı..: ");
        mudur.setIsim(sc.nextLine());

        System.out.println("Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        mudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("müdürün yaşı..: ");
        mudur.setYas(sc.nextInt());

        System.out.println("müdürün maaşı..: ");
        mudur.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Sorumlu olduklarıyla ilgili görev tanımı ");
        mudur.setGorevTanimi(sc.nextLine());

        System.out.println("Müdürün işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        mudur.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        System.out.println("Müdürün sorumlu olduğu departmanı giriniz.");
        //müdüre sorumlu olduğu departmanı atamak...
        var value = 1;
        var departmanSahiplikSayisi = 1;
        do{
            switch (value) {
                case 1:
                    int index2 = 1;
                    for (Departman departman : StaticValues.departmanListesi) {
                        System.out.println(index2 + " -> " + departman.getAd());
                        index2++;
                    }
                    int secim2 = sc.nextInt();
                    mudur.getMudurlerinSorumluOlduguDepartmanListesi().add(StaticValues.departmanListesi.get(secim2 - 1));
                    break;
                case 0:
                    System.out.println("Cıkıs Yapiliyor");
                    break;
            }
            departmanSahiplikSayisi++;
            System.out.println("[1] -> "+departmanSahiplikSayisi+". departmanı ekle");
            System.out.println("[0] -> Departman atama işleminden çık ve mudurun bilgilerini oluşturmaya devam et");
            value = sc.nextInt();
        }while(value != 0);
        // stat values da mapin içine atıyoruz
        StaticValues.mapMudurDepartmanListesi.put(mudur,mudur.getMudurlerinSorumluOlduguDepartmanListesi());

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        mudur.setDepartman(StaticValues.departmanListesi.get(secim-1));
        mudur.getDepartman().getDepartmanPersonelListesi().add(mudur);

        personelService.update(mudur);
    }
}
