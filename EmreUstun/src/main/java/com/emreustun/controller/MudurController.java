package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Mudur;
import com.emreustun.service.MudurService;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class MudurController {
    MudurService mudurService = new MudurService();
    Scanner sc;
    Mudur mudur;
    public void save() {
        sc = new Scanner(System.in);
        mudur = new Mudur();
        System.out.println("Müdür Kayıt ediyorusunuz..");

        System.out.println("Müdürün adı..: ");
        mudur.setIsim(sc.nextLine());

        System.out.println("Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        mudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Müdürün yaşı..: ");
        mudur.setYas(sc.nextInt());

        System.out.println("Müdürün maaşı..: ");
        mudur.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Müdürn görev tanımını giriniz..: ");
        mudur.setGorevTanimi(sc.nextLine());

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        mudur.setDepartman(StaticValues.departmanListesi.get(secim-1));

        mudurService.save(mudur);
    }

    public void update() {
        mudur = new Mudur();
        sc = new Scanner(System.in);

        // System.out.println("Müdürler listeleniyor..: ");
        // müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        mudur.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Mudurun adı..: ");
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

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        mudur.setDepartman(StaticValues.departmanListesi.get(secim-1));

        mudurService.update(mudur);
    }
}
