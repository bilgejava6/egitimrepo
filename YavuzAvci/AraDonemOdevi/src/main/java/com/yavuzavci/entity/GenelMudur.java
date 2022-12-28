package com.yavuzavci.entity;

import static com.yavuzavci.utility.StaticValues.departmanListesi;

public class GenelMudur extends Mudur {

    public GenelMudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        this.setDepartmanlar(departmanListesi.values().stream().toList());
    }

    public GenelMudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        this.setDepartmanlar(departmanListesi.values().stream().toList());
    }
}
