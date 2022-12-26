package com.emreustun.entity;

import java.util.List;

public class Departman {
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
                "ad='" + ad + '\'' +
                ", vardiyaSayisi=" + vardiyaSayisi +
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

}
