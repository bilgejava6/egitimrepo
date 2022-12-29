package com.aliakkulah.entity;

import static com.aliakkulah.utility.Utility.departmanListesi;
import static com.aliakkulah.utility.Utility.personelListesi;

public class MuhasebePersoneli extends Personel {
    private double yatirdigiMaasMiktari;
    private int yatirdigiMaasAdeti;

    public MuhasebePersoneli() {

    }

    public MuhasebePersoneli(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int depIndex, double yatirdigiMaasMiktari, int yatirdigiMaasAdeti) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas, depIndex);
        this.yatirdigiMaasMiktari = yatirdigiMaasMiktari;
        this.yatirdigiMaasAdeti = yatirdigiMaasAdeti;
    }

    public double getYatirdigiMaasMiktari() {
        return yatirdigiMaasMiktari;
    }

    public void setYatirdigiMaasMiktari(double yatirdigiMaasMiktari) {
        this.yatirdigiMaasMiktari = yatirdigiMaasMiktari;
    }

    public double getYatirdigiMaasAdeti() {
        return yatirdigiMaasAdeti;
    }

    public void setYatirdigiMaasAdeti(int yatirdigiMaasAdeti) {
        this.yatirdigiMaasAdeti = yatirdigiMaasAdeti;
    }

    @Override
    public String toString() {
        return super.toString() + "MuhasebePersoneli [yatirdigiMaasMiktari=" + yatirdigiMaasMiktari + ", yatirdigiMaasAdeti="
                + yatirdigiMaasAdeti + ", getCinsiyet()=" + getCinsiyet() + ", getId()=" + getId() + ", getAd()="
                + getAd() + ", getSoyad()=" + getSoyad() + ", getUnvan()=" + getUnvan() + ", getIseGirisTarihi()="
                + getIseGirisTarihi() + ", getDogumYili()=" + getDogumYili() + ", getMaas()=" + getMaas() + "]";
    }
}