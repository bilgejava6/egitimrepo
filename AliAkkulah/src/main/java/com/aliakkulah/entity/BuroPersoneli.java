package com.aliakkulah.entity;

import static com.aliakkulah.utility.Utility.departmanListesi;

public class BuroPersoneli extends Personel {
    private int dosyalamaHiziDerecesi;

    public BuroPersoneli() {
    }

    public BuroPersoneli(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili,
                         String cinsiyet, double maas, int depIndex, int dosyalamaHiziDerecesi) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas, depIndex);
        this.dosyalamaHiziDerecesi = dosyalamaHiziDerecesi;
    }

    public int getDosyalamaHiziDerecesi() {
        return dosyalamaHiziDerecesi;
    }

    public void setDosyalamaHiziDerecesi(int dosyalamaHiziDerecesi) {
        this.dosyalamaHiziDerecesi = dosyalamaHiziDerecesi;
    }

    @Override
    public String toString() {
        return "BuroPersoneli [dosyalamaHiziDerecesi=" + dosyalamaHiziDerecesi + ", getCinsiyet()=" + getCinsiyet()
                + ", getId()=" + getId() + ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad() + ", getUnvan()="
                + getUnvan() + ", getIseGirisTarihi()=" + getIseGirisTarihi() + ", getDogumYili()=" + getDogumYili()
                + ", getMaas()=" + getMaas() + "]";
    }
}