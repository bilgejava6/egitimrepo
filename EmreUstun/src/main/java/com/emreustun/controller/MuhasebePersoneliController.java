package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.MuhasebePersoneli;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class MuhasebePersoneliController {
    MuhasebePersoneli muhasebePersoneli;
    PersonelService personelService = new PersonelService();
    Scanner sc ;
    public void save() {

        sc = new Scanner(System.in);
        muhasebePersoneli = new MuhasebePersoneli();
        System.out.println("Muhasabe Personeli Kayıt ediyorusunuz..");

        System.out.println("Muhasabe personelin adı ve soyadı..: ");
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

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        muhasebePersoneli.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        muhasebePersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));
        muhasebePersoneli.getDepartman().getDepartmanPersonelListesi().add(muhasebePersoneli);

        personelService.save(muhasebePersoneli);
    }

    public void update() {
        muhasebePersoneli = new MuhasebePersoneli();
        sc = new Scanner(System.in);

        // System.out.println("Genel Müdürler listeleniyor..: ");
        // Genel müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        muhasebePersoneli.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Muhasabe personeli adı ve soyadı..: ");
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

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        muhasebePersoneli.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        // Departman atamak...
        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        int index = 1;
        for(Departman departman : StaticValues.departmanListesi){
            System.out.println(index+" -> "+departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        muhasebePersoneli.setDepartman(StaticValues.departmanListesi.get(secim-1));
        muhasebePersoneli.getDepartman().getDepartmanPersonelListesi().add(muhasebePersoneli);

        personelService.update(muhasebePersoneli);
    }
}
