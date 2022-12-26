package com.yavuzavci.entity;

public class InsanKaynaklariPersoneli extends Personel {

    public InsanKaynaklariPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
    }

    public InsanKaynaklariPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
    }
}
