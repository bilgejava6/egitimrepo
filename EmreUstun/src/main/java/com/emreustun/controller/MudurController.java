package com.emreustun.controller;

import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Mudur;
import com.emreustun.service.PersonelService;

import java.util.Scanner;

public class MudurController {
    PersonelService personelRepository = new PersonelService();
    Scanner sc;
    Mudur mudur;
    public void save() {
        sc = new Scanner(System.in);
        mudur = new Mudur();
        System.out.println("Müdür Kayıt ediyorusunuz..");

        System.out.println("Müdürün adı..: ");
        mudur.setIsim(sc.nextLine());

        System.out.println("Müdürün cinsiyeti..: (ERKEK-KADIN-BELIRTMEKISTEMIYOR)");
        mudur.setCinsiyet(ECinsiyet.valueOf(sc.nextLine().toUpperCase()));

        System.out.println("Müdürün yaşı..: ");
        mudur.setYas(sc.nextInt());

        System.out.println("Müdürün maaşı..: ");
        mudur.setMaas(sc.nextInt());

        System.out.println("Müdürn görev tanımını giriniz..: ");
        mudur.setGorevTanimi(sc.nextLine());

        personelRepository.save(mudur);
    }
}
