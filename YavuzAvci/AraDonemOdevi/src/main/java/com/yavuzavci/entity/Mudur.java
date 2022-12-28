package com.yavuzavci.entity;

import java.util.ArrayList;
import java.util.List;

public class Mudur extends Personel {
    private List<Departman> departmanlar;

    public Mudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        departmanlar = new ArrayList<>();
    }

    public Mudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        departmanlar = new ArrayList<>();
    }

    public List<Departman> getDepartmanlar() {
        return departmanlar;
    }

    public void setDepartmanlar(List<Departman> departmanlar) {
        this.departmanlar = departmanlar;
    }
}
