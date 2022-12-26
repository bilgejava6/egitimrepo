package com.emreustun.entity;

import java.util.List;

public class Departman {


    private Personel personel;
    private String ad;
    private int vardiyaSayisi;

    public int getVardiyaSayisi() {
        return vardiyaSayisi;
    }

    public void setVardiyaSayisi(int vardiyaSayisi) {
        this.vardiyaSayisi = vardiyaSayisi;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "personel=" + personel +
                ", ad='" + ad + '\'' +
                '}';
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Departman() {
    }
    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

}
