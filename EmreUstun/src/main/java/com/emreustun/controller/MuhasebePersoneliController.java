package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.MuhasebePersoneli;
import com.emreustun.repository.PersonelRepository;
import com.emreustun.service.MuhasebePersoneliService;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class MuhasebePersoneliController {
    MuhasebePersoneli muhasebePersoneli;
    MuhasebePersoneliService muhasebePersoneliService = new MuhasebePersoneliService();
    Scanner sc ;
    public void save() {

        sc = new Scanner(System.in);
        muhasebePersoneli = new MuhasebePersoneli();
        System.out.println("Muhasabe Personeli Kayıt ediyorusunuz..");

        System.out.println("Muhasabe personelin adı..: ");
        muhasebePersoneli.setIsim(sc.nextLine());

        System.out.println("Muhasabe personelinin cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        muhasebePersoneli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Muhasebe Personeli personelin yaşı..: ");
        muhasebePersoneli.setYas(sc.nextInt());

        System.out.println("muhasebePersoneli maaşı..: ");
        muhasebePersoneli.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Muhasabe personeli görevi..: ");
        muhasebePersoneli.setGorev(sc.nextLine());

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        muhasebePersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));

        muhasebePersoneliService.save(muhasebePersoneli);
    }

    public void update() {
        muhasebePersoneli = new MuhasebePersoneli();
        sc = new Scanner(System.in);

        // System.out.println("Genel Müdürler listeleniyor..: ");
        // Genel müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        muhasebePersoneli.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Muhasabe personeli adı..: ");
        muhasebePersoneli.setIsim(sc.nextLine());

        System.out.println("Muhasabe personeli cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        muhasebePersoneli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Muhasabe personeli yaşı..: ");
        muhasebePersoneli.setYas(sc.nextInt());

        System.out.println("Muhasabe personeli maaşı..: ");
        muhasebePersoneli.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Muhasabe personeli görevi..: ");
        muhasebePersoneli.setGorev(sc.nextLine());

        // Departman atamak...
        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        muhasebePersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));

        muhasebePersoneliService.update(muhasebePersoneli);
    }
}
