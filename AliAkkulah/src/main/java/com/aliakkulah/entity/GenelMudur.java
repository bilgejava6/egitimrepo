package com.aliakkulah.entity;

import static com.aliakkulah.utility.Utility.departmanListesi;
import static com.aliakkulah.utility.Utility.personelListesi;

public class GenelMudur extends Personel {
    private int bonusZamOrani;

    public GenelMudur() {
    }

    public GenelMudur(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int depIndex, int bonusZamOrani) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas, depIndex);
        this.bonusZamOrani = bonusZamOrani;
    }

    public int getBonusZamOrani() {
        return bonusZamOrani;
    }

    public void setBonusZamOrani(int bonusZamOrani) {
        this.bonusZamOrani = bonusZamOrani;
    }

    @Override
    public String toString() {
        return "GenelMudur [bonusZamOrani=" + bonusZamOrani + ", getCinsiyet()=" + getCinsiyet() + ", getId()="
                + getId() + ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad() + ", getUnvan()=" + getUnvan()
                + ", getIseGirisTarihi()=" + getIseGirisTarihi() + ", getDogumYili()=" + getDogumYili() + ", getMaas()="
                + getMaas() + "]";
    }
}