package com.aliakkulah.entity;

import static com.aliakkulah.utility.Utility.departmanListesi;
import static com.aliakkulah.utility.Utility.personelListesi;

public class IKPersoneli extends Personel {
    private int iletisimKurmnaDerecesi;
    private int iseAlimSayisi;
    private int istenCikarmaSayisi;
    private int girdigiMulakatSayisi;

    public IKPersoneli() {
    }

    public IKPersoneli(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int depIndex, int iletisimKurmnaDerecesi, int iseAlimSayisi, int istenCikarmaSayisi, int girdigiMulakatSayisi) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas, depIndex);
        this.iletisimKurmnaDerecesi = iletisimKurmnaDerecesi;
        this.iseAlimSayisi = iseAlimSayisi;
        this.istenCikarmaSayisi = istenCikarmaSayisi;
        this.girdigiMulakatSayisi = girdigiMulakatSayisi;
    }

    public int getIletisimKurmnaDerecesi() {
        return iletisimKurmnaDerecesi;
    }

    public void setIletisimKurmnaDerecesi(int iletisimKurmnaDerecesi) {
        this.iletisimKurmnaDerecesi = iletisimKurmnaDerecesi;
    }

    public int getIseAlimSayisi() {
        return iseAlimSayisi;
    }

    public void setIseAlimSayisi(int iseAlimSayisi) {
        this.iseAlimSayisi = iseAlimSayisi;
    }

    public int getIstenCikarmaSayisi() {
        return istenCikarmaSayisi;
    }

    public void setIstenCikarmaSayisi(int istenCikarmaSayisi) {
        this.istenCikarmaSayisi = istenCikarmaSayisi;
    }

    public int getGirdigiMulakatSayisi() {
        return girdigiMulakatSayisi;
    }

    public void setGirdigiMulakatSayisi(int girdigiMulakatSayisi) {
        this.girdigiMulakatSayisi = girdigiMulakatSayisi;
    }

    @Override
    public String toString() {
        return "IKPersoneli [iletisimKurmnaDerecesi=" + iletisimKurmnaDerecesi + ", iseAlimSayisi=" + iseAlimSayisi
                + ", istenCikarmaSayisi=" + istenCikarmaSayisi + ", girdigiMulakatSayisi=" + girdigiMulakatSayisi
                + ", getCinsiyet()=" + getCinsiyet() + ", getId()=" + getId() + ", getAd()=" + getAd() + ", getSoyad()="
                + getSoyad() + ", getUnvan()=" + getUnvan() + ", getIseGirisTarihi()=" + getIseGirisTarihi()
                + ", getDogumYili()=" + getDogumYili() + ", getMaas()=" + getMaas() + "]";
    }
}