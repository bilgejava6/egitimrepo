package com.emreustun.controller;

import com.emreustun.entity.*;
import com.emreustun.service.BuroPersoneliService;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class BuroPersoneliController {
    BuroPersoneliService buroPersoneliService = new BuroPersoneliService();
    Scanner sc;
    BuroPersoneli buroPersoneli;

    public void save() {

        sc = new Scanner(System.in);
        buroPersoneli = new BuroPersoneli();
        System.out.println("Büro Personel Kayıt ediyorusunuz..");

        System.out.println("Büro personelin adı..: ");
        buroPersoneli.setIsim(sc.nextLine());

        System.out.println("Büro personelin cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        buroPersoneli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Büro personelin yaşı..: ");
        buroPersoneli.setYas(sc.nextInt());

        System.out.println("Büro personelin maaşı..: ");
        buroPersoneli.setMaas(sc.nextInt());

        System.out.println("Büro personelinin ofis numarası...: ");
        buroPersoneli.setOfisNo(sc.nextInt());

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        buroPersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));

        buroPersoneliService.save(buroPersoneli);
    }

    public void update() {
        buroPersoneli = new BuroPersoneli();
        sc = new Scanner(System.in);

        // System.out.println("Genel Müdürler listeleniyor..: ");
        // Genel müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        buroPersoneli.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Buro personeli adı..: ");
        buroPersoneli.setIsim(sc.nextLine());

        System.out.println("Buro personeli cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        buroPersoneli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Buro personeli yaşı..: ");
        buroPersoneli.setYas(sc.nextInt());

        System.out.println("Buro personeli maaşı..: ");
        buroPersoneli.setMaas(sc.nextInt());

        System.out.println("Büro personelinin ofis numarası...: ");
        buroPersoneli.setOfisNo(sc.nextInt());

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        buroPersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));

        buroPersoneliService.update(buroPersoneli);
    }
}
