package com.emreustun.controller;

import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.Mudur;
import com.emreustun.entity.TeknikPersonel;
import com.emreustun.service.PersonelService;

import java.util.Scanner;

public class TeknikPersonelController {
    PersonelService personelRepository = new PersonelService();
    Scanner sc;
    TeknikPersonel teknikPersonel;

    public void save() {

        sc = new Scanner(System.in);
        teknikPersonel = new TeknikPersonel();
        System.out.println("Teknik Personel Kayıt ediyorusunuz..");

        System.out.println("Müdürün adı..: ");
        teknikPersonel.setIsim(sc.nextLine());

        System.out.println("Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        teknikPersonel.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Müdürün yaşı..: ");
        teknikPersonel.setYas(sc.nextInt());

        System.out.println("Müdürün maaşı..: ");
        teknikPersonel.setMaas(sc.nextInt());


        personelRepository.save(teknikPersonel);


    }
}

