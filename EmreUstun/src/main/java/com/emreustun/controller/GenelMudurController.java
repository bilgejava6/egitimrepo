package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;
import com.emreustun.service.GenelMudurService;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class GenelMudurController {
    GenelMudurService genelMudurService = new GenelMudurService();
    Scanner sc;
    GenelMudur genelMudur;
    public void save() {
        sc = new Scanner(System.in);
        genelMudur = new GenelMudur();
        System.out.println("Genel Müdür Kayıt ediyorusunuz..");

        System.out.println("Genel Mudurun adı..: ");
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

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        genelMudur.setDepartman(StaticValues.departmanListesi.get(secim-1));

        genelMudurService.save(genelMudur);
    }

    public void update() {
        genelMudur = new GenelMudur();
        sc = new Scanner(System.in);

        // System.out.println("Genel Müdürler listeleniyor..: ");
        // Genel müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        genelMudur.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Genel Mudurun adı..: ");
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

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        genelMudur.setDepartman(StaticValues.departmanListesi.get(secim-1));
        System.out.println("Personel başarı ile eklendi..");

        genelMudurService.update(genelMudur);
    }
}
