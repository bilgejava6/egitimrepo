package com.emreustun.controller;

import com.emreustun.entity.*;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class HizmetliController{
    PersonelService personelService = new PersonelService();
    Scanner sc;
    Hizmetli hizmetli;
    public void save() {
        sc = new Scanner(System.in);
        hizmetli = new Hizmetli();
        System.out.println("Hizmetli Kayıt ediyorusunuz..");

        System.out.println("Hizmetli adı ve soyadı..: ");
        hizmetli.setIsim(sc.nextLine());

        System.out.println("Hizmetli cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        hizmetli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Hizmetli yaşı..: ");
        hizmetli.setYas(sc.nextInt());

        System.out.println("Hizmetli maaşı..: ");
        hizmetli.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Hizmetlinin sorumlu olduğu alanları giriniz...: ");
        hizmetli.setCalismaYeri(sc.nextLine());

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        hizmetli.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        // Departman atamak...
        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        hizmetli.setDepartman(StaticValues.departmanListesi.get(secim-1));
        hizmetli.getDepartman().getDepartmanPersonelListesi().add(hizmetli);

        personelService.save(hizmetli);
    }

    public void update() {
        hizmetli = new Hizmetli();
        sc = new Scanner(System.in);

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        hizmetli.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Hizmetli adı ve soyadı..: ");
        hizmetli.setIsim(sc.nextLine());

        System.out.println("Hizmetli cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        hizmetli.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Hizmetli yaşı..: ");
        hizmetli.setYas(sc.nextInt());

        System.out.println("Hizmetli maaşı..: ");
        hizmetli.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Hizmetinin çalışacağı yerleri giriniz...: ");
        hizmetli.setCalismaYeri(sc.nextLine());

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        hizmetli.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        // Departman atamak...
        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        hizmetli.setDepartman(StaticValues.departmanListesi.get(secim-1));
        hizmetli.getDepartman().getDepartmanPersonelListesi().add(hizmetli);

        personelService.update(hizmetli);
    }
}
