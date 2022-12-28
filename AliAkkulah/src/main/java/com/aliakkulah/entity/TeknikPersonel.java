package com.aliakkulah.entity;

public class TeknikPersonel extends Personel {
    private boolean meslekYeterlilikBelgesiVarMi;

    public TeknikPersonel() {
    }

    public TeknikPersonel(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, boolean meslekYeterlilikBelgesiVarMi) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas);
        this.meslekYeterlilikBelgesiVarMi = meslekYeterlilikBelgesiVarMi;
    }

    public boolean isMeslekYeterlilikBelgesiVarMi() {
        return meslekYeterlilikBelgesiVarMi;
    }

    public void setMeslekYeterlilikBelgesiVarMi(boolean meslekYeterlilikBelgesiVarMi) {
        this.meslekYeterlilikBelgesiVarMi = meslekYeterlilikBelgesiVarMi;
    }

    @Override
    public String toString() {
        return "TeknikPersonel [meslekYeterlilikBelgesiVarMi=" + meslekYeterlilikBelgesiVarMi + ", getCinsiyet()="
                + getCinsiyet() + ", getId()=" + getId() + ", getAd()=" + getAd() + ", getSoyad()=" + getSoyad()
                + ", getUnvan()=" + getUnvan() + ", getIseGirisTarihi()=" + getIseGirisTarihi() + ", getDogumYili()="
                + getDogumYili() + ", getMaas()=" + getMaas() + "]";
    }
}