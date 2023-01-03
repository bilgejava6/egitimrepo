package com.volkangenel.odev.repository.entity;

import java.util.Arrays;

public class Hizmetli extends Personel {
    private String [] temizlikalanlari;

    public Hizmetli(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, String[] temizlikalanlari) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.temizlikalanlari = temizlikalanlari;
    }

    @Override
    public String toString() {
        return "Hizmetli{" +
                "temizlikalanlari=" + Arrays.toString(temizlikalanlari) +
                '}';
    }

    public String[] getTemizlikalanlari() {
        return temizlikalanlari;
    }

    public void setTemizlikalanlari(String[] temizlikalanlari) {
        this.temizlikalanlari = temizlikalanlari;
    }
}
