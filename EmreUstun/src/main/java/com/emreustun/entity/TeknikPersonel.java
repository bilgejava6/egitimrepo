package com.emreustun.entity;

public class TeknikPersonel extends Personel{
    private String meslekiBeceri;
    private String bolum;

    public TeknikPersonel() {
        super();
        this.meslekiBeceri = meslekiBeceri;
        this.bolum = bolum;
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
