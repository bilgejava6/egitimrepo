package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

public class Departman extends BaseEntity{
    private String ad;
    private int personelSayisi=0;

    public Departman() {
        super();
        this.setId(StaticValues.departmanIdOlustur());
    }
    public Departman(String ad) {
        super();
        this.ad = ad;
        this.setId(StaticValues.departmanIdOlustur());
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public int getPersonelSayisi() {
        return personelSayisi;
    }
    public void setPersonelSayisi(int personelSayisi) {
        this.personelSayisi = personelSayisi;
    }
    @Override
    public String toString() {
        return "Departman [ad=" + ad + ", personelSayisi=" + personelSayisi + ", getCreateDate()=" + getCreateDate()
                + "]";
    }

}

