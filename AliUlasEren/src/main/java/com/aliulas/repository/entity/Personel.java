package com.aliulas.repository.entity;

import static com.aliulas.utility.StaticValues.idOlustur;

public class Personel extends BaseEntity {
    private int id;
    private String ad;
    private String soyad;
    private String email;
    private String telefon;

    private String departman;
    private String pozisyon;
    private String kayitTarihi;
    private int maas;

    public Personel() {
        super();
    }

    public Personel(String ad, String soyad, String email, String telefon,  String pozisyon,
                    int maas,String kayitTarihi,String departman) {
        super();
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefon = telefon;
        this.departman = departman;
        this.pozisyon = pozisyon;
        this.maas = maas;
        this.kayitTarihi = kayitTarihi;
        this.id = idOlustur();
    }

    @Override
    public String toString() {
        return "Personel [ad=" + ad + ", soyad=" + soyad + ", email=" + email + ", telefon=" + telefon +  ", pozisyon=" + pozisyon + ", maas=" + maas + "]";
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    public String getPozisyon() {
        return pozisyon;
    }
    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }
    public int getMaas() {
        return maas;
    }
    public void setMaas(int maas) {
        this.maas = maas;
    }

    public String getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(String kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }
}
