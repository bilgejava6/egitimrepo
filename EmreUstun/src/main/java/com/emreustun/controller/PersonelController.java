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
        if(StaticValues.departmanListesi.isEmpty()){
            System.out.println("Lütfen önce departman ekleyiniz..");
        }else {
            System.out.println("Personeli kayıt ekranina hosgeldiniz..");
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
                case 1: genelMudurController.save(); break;
                case 2: mudurController.save(); break;
                case 3: insanKaynaklariPersoneliController.save(); break;
                case 4: muhasebePersoneliController.save(); break;
                case 5: buroPersoneliController.save(); break;
                case 6: teknikPersonelController.save(); break;
                case 7: hizmetliController.save(); break;
            }
        }



    }

    public void update() {
        System.out.println("Personel Düzenleme");
        System.out.println("Düzenlenecek kişinin idsi ile düzenleyiniz.");
        StaticValues.personelListesi.forEach(System.out::println);
        sc = new Scanner(System.in);
 //       personel = new Personel();

        System.out.println("Kişinin  adı ve soyadi..: ");
        personel.setIsim(sc.nextLine());

        System.out.println("Kişinin yaşı");
        personel.setMaas(sc.nextInt());

        System.out.println("Kişinin maaşı");
        personel.setMaas(sc.nextInt());

        System.out.println("Kişinin cinsiyeti..: ERKEK / KADIN");
        personel.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Kişinin departmanı");
        Departman departman = new Departman(sc.nextLine());
        personel.setDepartman(departman);
        service.update(personel);

    }
}
