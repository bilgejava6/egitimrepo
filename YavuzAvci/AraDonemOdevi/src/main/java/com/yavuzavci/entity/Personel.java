package com.yavuzavci.entity;

public abstract class Personel extends BaseEntity {

    private String adSoyad;
    private ECinsiyet cinsiyet;
    private Integer yas;
    private String telefon;
    private Departman departman;
    private Double maas;
    private Double odenmisUcret;

    public Personel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super();
        this.adSoyad = adSoyad;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.telefon = telefon;
        this.departman = departman;
        maas = 0D;
        odenmisUcret = 0D;
    }

    public Personel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super();
        this.adSoyad = adSoyad;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.telefon = telefon;
        this.departman = departman;
        this.maas = maas;
        odenmisUcret = 0D;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public ECinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(ECinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    public Double getMaas() {
        return maas;
    }

    public void setMaas(Double maas) {
        this.maas = maas;
    }

    public Double getOdenmisUcret() {
        return odenmisUcret;
    }

    public void setOdenmisUcret(Double odenmisUcret) {
        this.odenmisUcret = odenmisUcret;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                '{' +
                "adSoyad= '" + adSoyad + '\'' +
                ", yas= " + yas +
                ", telefon= '" + telefon + '\'' +
                ", departman= " + departman +
                ", maas= " + maas +
                '}';
    }
}
