package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.Personel;
import com.emreustun.service.PersonelService;
import com.emreustun.utility.StaticValues;

import java.util.List;
import java.util.Scanner;

public class PersonelController {
    PersonelService service = new PersonelService();
    Scanner sc;
    Personel personel;

    public void save() {
        System.out.println("Personel Ekleme");
        sc = new Scanner(System.in);
        personel = new Personel();

        System.out.println("Personelin  adı ve soyadi..: ");
        personel.setIsim(sc.nextLine());

        System.out.println("Kişinin yaşı");
        personel.setYas(sc.nextInt());

        System.out.println("Kişinin maaşı");
        personel.setMaas(sc.nextInt());

        sc.nextLine();
        System.out.println("Kişinin cinsiyeti..: ERKEK / KADIN");
        String value= sc.nextLine();
        personel.setCinsiyet(ECinsiyet.valueOf(value));

        System.out.println("Kişinin departmanı");
        String departmanAdi = sc.nextLine();
        Departman departman = new Departman(departmanAdi);
        personel.setDepartman(departman);
        service.save(personel);
    }

    public void update() {
        System.out.println("Personel Düzenleme");
        System.out.println("Düzenlenecek kişinin idsi ile düzenleyiniz.");
        StaticValues.personelListesi.forEach(System.out::println);
        sc = new Scanner(System.in);
        personel = new Personel();

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
