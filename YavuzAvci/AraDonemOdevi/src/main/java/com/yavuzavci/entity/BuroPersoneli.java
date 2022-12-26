package com.yavuzavci.entity;

public class BuroPersoneli extends Personel {

    public BuroPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
    }

    public BuroPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
    }
}
