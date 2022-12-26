package com.yavuzavci.entity;

public class TeknikPersonel extends Personel {

    public TeknikPersonel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
    }

    public TeknikPersonel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
    }
}
