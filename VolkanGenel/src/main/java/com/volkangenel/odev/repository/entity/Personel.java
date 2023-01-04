package com.volkangenel.odev.repository.entity;

import odev.repository.entity.utility.StaticValues;

public class Personel extends BaseEntity{

    private Long id;
    private String ad;
    private String soyisim;
    private String unvan;
    private double maas;
    private String telefon;
    private String aciltelefon;
    private String tckimlik;
    private Departman departman;

    public Personel() {
        this.id = StaticValues.idOlustur();
    }

    public Personel(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman) {
        this.id = StaticValues.idOlustur();
        this.ad = ad;
        this.soyisim = soyisim;
        this.unvan = unvan;
        this.maas = maas;
        this.telefon = telefon;
        this.aciltelefon = aciltelefon;
        this.tckimlik = tckimlik;
        this.departman = departman;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", unvan='" + unvan + '\'' +
                ", maas=" + maas +
                ", telefon='" + telefon + '\'' +
                ", aciltelefon='" + aciltelefon + '\'' +
                ", tckimlik='" + tckimlik + '\'' +
                ", departman=" + departman +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", isActive=" + isActive +
                ", state=" + state +
                '}';
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

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAciltelefon() {
        return aciltelefon;
    }

    public void setAciltelefon(String aciltelefon) {
        this.aciltelefon = aciltelefon;
    }

    public String getTckimlik() {
        return tckimlik;
    }

    public void setTckimlik(String tckimlik) {
        this.tckimlik = tckimlik;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }
}
