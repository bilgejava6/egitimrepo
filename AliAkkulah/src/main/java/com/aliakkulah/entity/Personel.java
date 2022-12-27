package com.aliakkulah.entity;

import static com.aliakkulah.utility.Utility.*;

public abstract class Personel {
    public String getCinsiyet() {
        return cinsiyet;
    }
    private Long id;
    private String ad;
    private String soyad;
    private String unvan;
    private String iseGirisTarihi;
    private int dogumYili;
    private String cinsiyet;

    private double maas;

    public Personel() {
    }

    public Personel(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas) {
        this.ad = ad;
        this.soyad = soyad;
        this.unvan = unvan;
        this.iseGirisTarihi = iseGirisTarihi;
        this.dogumYili = dogumYili;
        this.cinsiyet = cinsiyet;
        this.maas = maas;
        this.id = idOlustur();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(String iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public int getDogumYili() {
        return dogumYili;
    }

    public void setDogumYili(int dogumYili) {
        this.dogumYili = dogumYili;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }
}