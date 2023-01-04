package com.emreustun.controller;

import com.emreustun.entity.*;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.Scanner;

public class TeknikPersonelController {
    PersonelService personelService = new PersonelService();
    Scanner sc;
    TeknikPersonel teknikPersonel;

    public void save() {

        sc = new Scanner(System.in);
        teknikPersonel = new TeknikPersonel();
        System.out.println("Teknik Personel Kayıt ediyorusunuz..");

        System.out.println("Teknik personelin adı ve soyadı..: ");
        teknikPersonel.setIsim(sc.nextLine());

        System.out.println("Teknik personelin cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        teknikPersonel.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Teknik personelin yaşı..: ");
        teknikPersonel.setYas(sc.nextInt());

        System.out.println("Teknik personelin maaşı..: ");
        teknikPersonel.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Teknik personelin mesleki becerisi..: ");
        teknikPersonel.setMeslekiBeceri(sc.nextLine());

        System.out.println("Teknik personelin bölümü..: ");
        teknikPersonel.setBolum(sc.nextLine());

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        teknikPersonel.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for (Departman departman : StaticValues.departmanListesi) {
            System.out.println(index + " -> " + departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        teknikPersonel.setDepartman(StaticValues.departmanListesi.get(secim - 1));
        teknikPersonel.getDepartman().getDepartmanPersonelListesi().add(teknikPersonel);

        personelService.save(teknikPersonel);
    }

    public void update() {
        teknikPersonel = new TeknikPersonel();
        sc = new Scanner(System.in);

        // System.out.println("Genel Müdürler listeleniyor..: ");
        // Genel müdürleri nasıl listelerim ?

        System.out.println("Değiştirmek istediğiniz personelin id'sini giriniz");
        teknikPersonel.setId(sc.nextLong());

        sc.nextLine();
        System.out.println("Teknik personel adı ve soyadı..: ");
        teknikPersonel.setIsim(sc.nextLine());

        System.out.println("Teknik personel cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        teknikPersonel.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Teknik personel yaşı..: ");
        teknikPersonel.setYas(sc.nextInt());

        System.out.println("Teknik personel maaşı..: ");
        teknikPersonel.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Teknik personelin mesleki becerisi..: ");
        teknikPersonel.setMeslekiBeceri(sc.nextLine());

        System.out.println("Teknik personelin bölümü..: ");
        teknikPersonel.setBolum(sc.nextLine());

        System.out.println("Personelin işe başlama tarihi..: ");
        System.out.println("Lütfen rakamları kullanınız !!");
        System.out.println("Yıl giriniz");
        int yil = sc.nextInt();
        System.out.println("Ay giriniz");
        int ay = sc.nextInt();
        System.out.println("Gün giriniz");
        int gun = sc.nextInt();
        teknikPersonel.setIseBaslamaTarihi(yil-1900,ay-1,gun);

        System.out.println("Personelin çalışacağı departmanın numarasını giriniz..: ");
        // Departman atamak...
        int index = 1;
        for (Departman departman : StaticValues.departmanListesi) {
            System.out.println(index + " -> " + departman.getAd());
            index++;
        }
        int secim = sc.nextInt();
        teknikPersonel.setDepartman(StaticValues.departmanListesi.get(secim - 1));

        teknikPersonel.getDepartman().getDepartmanPersonelListesi().add(teknikPersonel);

        personelService.update(teknikPersonel);
    }
}