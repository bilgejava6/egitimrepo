package com.aliakkulah.entity;

public class Hizmetli extends Personel {
    private int temizlikDerecesi; //0-5 arası puan -> 0-1-2 işten çıkarılma tehlikesi.
    // -> 3-4   standart
    // -> 5     bonus zam alabilir. terfi alabilir....


    public Hizmetli() {
    }

    public Hizmetli(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int temizlikDerecesi) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas);
        this.temizlikDerecesi = temizlikDerecesi;
    }

    public int getTemizlikDerecesi() {
        return temizlikDerecesi;
    }

    public void setTemizlikDerecesi(int temizlikDerecesi) {
        this.temizlikDerecesi = temizlikDerecesi;
    }

    @Override
    public String toString() {
        return "Hizmetli [temizlikDerecesi=" + temizlikDerecesi + ", getCinsiyet()=" + getCinsiyet() + ", getId()="
                + getId() + ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad() + ", getUnvan()=" + getUnvan()
                + ", getIseGirisTarihi()=" + getIseGirisTarihi() + ", getDogumYili()=" + getDogumYili() + ", getMaas()="
                + getMaas() + "]";
    }
}