package com.AraDonemOdevi.Entity;


public class Personel extends BaseEntity {

    String ad;
    String soyad;
    String telefon;
    String departman;
    int puan;

    int maas;



    @Override
    public String toString() {
        return "Personel{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", telefon='" + telefon + '\'' +
                ", departman='" + departman + '\'' +
                ", puan=" + puan + '\'' +
                ", id=" + id + '\'' +
                ", createDate=" + createDate + '\'' +
                ", updateDate=" + updateDate + '\'' +
                ", maas=" + maas + '\'' +
                '}';
    }

    public Personel() {

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }
}
