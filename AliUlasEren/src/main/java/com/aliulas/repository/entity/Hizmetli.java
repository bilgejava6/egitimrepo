package com.aliulas.repository.entity;

public class Hizmetli extends Personel{
    private String hizmetAlani;
    private int calismaSaatleri;


    public Hizmetli() {

    }

    public Hizmetli(String ad, String soyad, String email, String telefon,  String pozisyon, int maas, String kayitTarihi, String hizmetAlani,int calismaSaatleri) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi);
        this.hizmetAlani = hizmetAlani;
        this.calismaSaatleri= calismaSaatleri;
    }

    public String getHizmetAlani() {
        return hizmetAlani;
    }

    public void setHizmetAlani(String hizmetAlani) {
        this.hizmetAlani = hizmetAlani;
    }

    public int getCalismaSaatleri() {
        return calismaSaatleri;
    }

    public void setCalismaSaatleri(int calismaSaatleri) {
        this.calismaSaatleri = calismaSaatleri;
    }

    @Override
    public String toString() {
        return "Hizmetli [hizmetAlani=" + hizmetAlani + ", calismaSaatleri=" + calismaSaatleri + "]";
    }
}
