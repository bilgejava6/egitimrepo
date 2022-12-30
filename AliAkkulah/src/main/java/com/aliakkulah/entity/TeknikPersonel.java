package com.aliakkulah.entity;

import static com.aliakkulah.utility.Utility.departmanListesi;
import static com.aliakkulah.utility.Utility.personelListesi;

public class TeknikPersonel extends Personel {
    private boolean meslekYeterlilikBelgesiVarMi;

    public TeknikPersonel() {
    }

    public TeknikPersonel(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int depIndex,boolean meslekYeterlilikBelgesiVarMi) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas, depIndex);
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
        return "TeknikPersonel{" +
                "meslekYeterlilikBelgesiVarMi=" + meslekYeterlilikBelgesiVarMi +
                "} " + super.toString();
    }
}