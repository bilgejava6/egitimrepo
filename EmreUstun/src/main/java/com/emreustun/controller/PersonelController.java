package com.emreustun.controller;

import com.emreustun.entity.*;
import com.emreustun.repository.PersonelRepository;
import com.emreustun.service.GenelMudurService;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.List;
import java.util.Scanner;

public class PersonelController {
    PersonelService service = new PersonelService();
    GenelMudurController genelMudurController = new GenelMudurController();
    MudurController mudurController = new MudurController();
    InsanKaynaklariPersoneliController insanKaynaklariPersoneliController = new InsanKaynaklariPersoneliController();
    MuhasebePersoneliController muhasebePersoneliController = new MuhasebePersoneliController();
    BuroPersoneliController buroPersoneliController = new BuroPersoneliController();
    TeknikPersonelController teknikPersonelController = new TeknikPersonelController();
    HizmetliController hizmetliController = new HizmetliController();
    Scanner sc;
    Personel personel;

    public void save() {
        sc = new Scanner(System.in);
        if (StaticValues.departmanListesi.isEmpty()) {
            System.out.println("Departman ekleyemeden personel ekleyemezsiniz!!..");
        } else {
            System.out.println("Personel kayıt ekranina hosgeldiniz..");

            System.out.println("Lütfen önce hangi ünvan'da personel ekleyeceğinizi giriniz");
            System.out.println("1. Genel Müdür");
            System.out.println("2. Müdür");
            System.out.println("3. İnsan Kaynaklari");
            System.out.println("4. Muhasebe");
            System.out.println("5. Büro Personeli");
            System.out.println("6. Teknik Personel");
            System.out.println("7. Hizmetli");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    genelMudurController.save();
                    break;
                case 2:
                    mudurController.save();
                    break;
                case 3:
                    insanKaynaklariPersoneliController.save();
                    break;
                case 4:
                    muhasebePersoneliController.save();
                    break;
                case 5:
                    buroPersoneliController.save();
                    break;
                case 6:
                    teknikPersonelController.save();
                    break;
                case 7:
                    hizmetliController.save();
                    break;
            }
        }
    }

    public void update() {
        sc = new Scanner(System.in);
        System.out.println("Personel Düzenleme");
        System.out.println("Düzenlenecek kişinin ID sini aynı girerek oluşuturunuz..: ");
        StaticValues.personelListesi.forEach(System.out::println);

        System.out.println("Lütfen önce hangi ünvan'daki personeli değiştireceğinizi seçiniz..");
        System.out.println("1. Genel Müdür");
        System.out.println("2. Müdür");
        System.out.println("3. İnsan Kaynaklari");
        System.out.println("4. Muhasebe");
        System.out.println("5. Büro Personeli");
        System.out.println("6. Teknik Personel");
        System.out.println("7. Hizmetli");
        int secim = sc.nextInt();
        switch (secim) {
            case 1:
                genelMudurController.update();
                break;
            case 2:
                mudurController.update();
                break;
            case 3:
                insanKaynaklariPersoneliController.update();
                break;
            case 4:
                muhasebePersoneliController.update();
                break;
            case 5:
                buroPersoneliController.update();
                break;
            case 6:
                teknikPersonelController.update();
                break;
            case 7:
                hizmetliController.update();
                break;
        }
        int id = sc.nextInt();
        for (Personel personel : StaticValues.personelListesi) {
            if (id == personel.getId()) {
                service.update(personel);
            }
        }
    }

    public void findAll() {
        System.out.println("Tüm Personelin Listesi");
        for (Personel personel : service.findAll()) {
            System.out.println(personel);
        }
    }


}
