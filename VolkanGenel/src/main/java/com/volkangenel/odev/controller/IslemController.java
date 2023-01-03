package com.volkangenel.odev.controller;

import com.volkangenel.odev.repository.entity.Personel;
import com.volkangenel.odev.repository.entity.utility.StaticValues;
import com.volkangenel.odev.service.IslemService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IslemController{
    IslemService islemService = new IslemService();
    Scanner scanner;

    public void personelMaasiDuzenle() {
    scanner = new Scanner(System.in);
    double maas = 0;
    List<Double> maasListesi = new ArrayList<>();
        for (Personel personel: StaticValues.personelListesi) {
            System.out.println("Lütfen Id Sırasına Göre Maaş Bilgisini Giriniz");
            maas = scanner.nextDouble();
            maasListesi.add(maas);
        }
      islemService.personelMaasiDuzenle(maasListesi);
    }

    public void odemeListesi() {
        System.out.println(islemService.odemeListesi());
    }

    public void departmanPersonelListesi() {
    islemService.departmanPersonelListesi().forEach((x,y)-> System.out.println(x+" ---> " +y));
    }

    public void enCokPersonelBulunanDepartman () {
        System.out.println(islemService.enCokPersonelBulunanDepartman());
    }

    public void mudurSorumluluk () {

    }
    public void kayitTarihineGoreSirala() {
        islemService.kayitTarihineGoreSirala().forEach((x,y)-> System.out.println(x+" ---> " +y));
    }

}
