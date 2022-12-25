package com.emreustun.entity;

public class TeknikPersonel extends Personel{
    String meslekiBeceri;
    String bolum;

    public TeknikPersonel(String isim, int maas, int yas, ECinsiyet cinsiyet, Departman departman, String meslekiBeceri, String bolum) {
        super(isim, maas, yas, cinsiyet, departman);
        this.meslekiBeceri = meslekiBeceri;
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        return "TeknikPersonel{" +
                "meslekiBeceri='" + meslekiBeceri + '\'' +
                ", bolum='" + bolum + '\'' +
                '}';
    }

    public String getMeslekiBeceri() {
        return meslekiBeceri;
    }

    public void setMeslekiBeceri(String meslekiBeceri) {
        this.meslekiBeceri = meslekiBeceri;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }
}
