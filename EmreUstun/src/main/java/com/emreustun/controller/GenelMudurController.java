package com.emreustun.controller;

import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;
import com.emreustun.service.GenelMudurService;
import com.emreustun.service.PersonelService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GenelMudurController {
    PersonelService personelRepository = new PersonelService();
    Scanner sc;
    GenelMudur genelMudur;
    public void save() {
        sc = new Scanner(System.in);
        genelMudur = new GenelMudur();
        System.out.println("Genel Müdür Kayıt ediyorusunuz..");

        System.out.println("Genel Mudurun adı..: ");
        genelMudur.setIsim(sc.nextLine());

        System.out.println("Genel Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        genelMudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Genel müdürün yaşı..: ");
        genelMudur.setYas(sc.nextInt());

        System.out.println("Genel müdürün maaşı..: ");
        genelMudur.setMaas(sc.nextInt());

        System.out.println("Sorumlu olduklarıyla ilgili görev tanımı ");
        genelMudur.setGorevTanimi(sc.nextLine());

        personelRepository.save(genelMudur);
    }
}
