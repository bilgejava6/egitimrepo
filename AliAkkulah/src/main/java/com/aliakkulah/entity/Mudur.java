package com.aliakkulah.entity;

import java.util.List;

public class Mudur extends Personel {
    private int bonusZamMiktari;
    private List<Personel> sorumluOlduguCalisanlar;

    public Mudur() {
    }

    public Mudur(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int bonusZamMiktari, List<Personel> sorumluOlduguCalisanlar) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas);
        this.bonusZamMiktari = bonusZamMiktari;
        this.sorumluOlduguCalisanlar = sorumluOlduguCalisanlar;
    }

    public int getBonusZamMiktari() {
        return bonusZamMiktari;
    }

    public void setBonusZamMiktari(int bonusZamMiktari) {
        this.bonusZamMiktari = bonusZamMiktari;
    }

    public List<Personel> getSorumluOlduguCalisanlar() {
        return sorumluOlduguCalisanlar;
    }

    public void setSorumluOlduguCalisanlar(List<Personel> sorumluOlduguCalisanlar) {
        this.sorumluOlduguCalisanlar = sorumluOlduguCalisanlar;
    }

    @Override
    public String toString() {
        return "Mudur [bonusZamMiktari=" + bonusZamMiktari + ", sorumluOlduguCalisanlar=" + sorumluOlduguCalisanlar
                + ", getCinsiyet()=" + getCinsiyet() + ", getId()=" + getId() + ", getAd()=" + getAd() + ", getSoyad()="
                + getSoyad() + ", getUnvan()=" + getUnvan() + ", getIseGirisTarihi()=" + getIseGirisTarihi()
                + ", getDogumYili()=" + getDogumYili() + ", getMaas()=" + getMaas() + "]";
    }
}
