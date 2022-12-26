package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.InsanKaynaklariPersoneli;
import com.emreustun.service.InsanKaynaklariPersoneliService;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class InsanKaynaklariPersoneliController {
    InsanKaynaklariPersoneliService insanKaynaklariPersoneliService = new InsanKaynaklariPersoneliService();
    Scanner sc;
    InsanKaynaklariPersoneli insanKaynaklariPersoneli;
    public void save() {
        sc = new Scanner(System.in);
        insanKaynaklariPersoneli = new InsanKaynaklariPersoneli();
        System.out.println("İnsan Kaynaklari Personeli Kayıt ediyorusunuz..");

        System.out.println("İnsan Kaynaklari Personeli adı..: ");
        insanKaynaklariPersoneli.setIsim(sc.nextLine());

        System.out.println("İnsan Kaynaklari Personeli cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        insanKaynaklariPersoneli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("İnsan Kaynaklari Personeli yaşı..: ");
        insanKaynaklariPersoneli.setYas(sc.nextInt());

        System.out.println("İnsan Kaynaklari Personeli maaşı..: ");
        insanKaynaklariPersoneli.setMaas(sc.nextInt());

        System.out.println("İnsan kaynaklari personelinin ofis numarasını giriniz..");
        insanKaynaklariPersoneli.setOfisNo(sc.nextInt());

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        insanKaynaklariPersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));

        insanKaynaklariPersoneliService.save(insanKaynaklariPersoneli);
    }

    public void update() {
        insanKaynaklariPersoneli = new InsanKaynaklariPersoneli();
        sc= new Scanner(System.in);

        sc.nextLine();
        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        insanKaynaklariPersoneli.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("İnsan kaynakları personeli adi..: ");
        insanKaynaklariPersoneli.setIsim(sc.nextLine());

        System.out.println("İnsan kaynakları personeli cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        insanKaynaklariPersoneli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("İnsan kaynakları personeli yaşı..: ");
        insanKaynaklariPersoneli.setYas(sc.nextInt());

        System.out.println("İnsan kaynakları personeli maaşı..: ");
        insanKaynaklariPersoneli.setMaas(sc.nextInt());

        System.out.println("İnsan kaynaklari personelinin ofis numarasını giriniz..");
        insanKaynaklariPersoneli.setOfisNo(sc.nextInt());

        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        insanKaynaklariPersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));

        insanKaynaklariPersoneliService.update(insanKaynaklariPersoneli);

    }
}
