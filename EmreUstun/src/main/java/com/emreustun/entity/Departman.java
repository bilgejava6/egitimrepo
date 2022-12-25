package com.emreustun.entity;

import java.util.List;

public class Departman {
    private String ad;
    private int calisanSayisi;
    private List<Personel> departmanKisiListesi;

    @Override
    public String toString() {
        return "Departman{" +
                "ad='" + ad + '\'' +
                ", calisanSayisi=" + calisanSayisi +
                ", departmanKisiListesi=" + departmanKisiListesi +
                '}';
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getCalisanSayisi() {
        return calisanSayisi;
    }

    public void setCalisanSayisi(int calisanSayisi) {
        this.calisanSayisi = calisanSayisi;
    }

    public List<Personel> getDepartmanKisiListesi() {
        return departmanKisiListesi;
    }

    public void setDepartmanKisiListesi(List<Personel> departmanKisiListesi) {
        this.departmanKisiListesi = departmanKisiListesi;
    }

    public Departman(String ad) {
        this.ad = ad;
    }

}
