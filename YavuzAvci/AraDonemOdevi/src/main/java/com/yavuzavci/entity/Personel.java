package com.yavuzavci.entity;

public abstract class Personel extends BaseEntity {

    private String adSoyad;
    private ECinsiyet cinsiyet;
    private Integer yas;
    private String telefon;
    private Departman departman;
    private Double maas;
    private Double odenmisUcret;
    /**
     * Sadece ilgili personel için geçerli olan yetkilendirmeler.
     * Varsayılan olarak yetki olmayacaktır.
     */
    private boolean odemeyeYetkiliMi; // muhasebe,genel müdür
    private boolean maasTanimlayabilirMi; // ik, muhasebe, genel müdür
    private boolean istenCikarabilirMi; // müdür, genel müdür

    public Personel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super();
        this.adSoyad = adSoyad;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.telefon = telefon;
        this.departman = departman;
        maas = 0D;
        odenmisUcret = 0D;
        odemeyeYetkiliMi = false;
        maasTanimlayabilirMi = false;
        istenCikarabilirMi = false;
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
        odemeyeYetkiliMi = false;
        maasTanimlayabilirMi = false;
        istenCikarabilirMi = false;
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

    public boolean isOdemeyeYetkiliMi() {
        return odemeyeYetkiliMi;
    }

    public void setOdemeyeYetkiliMi(boolean odemeyeYetkiliMi) {
        this.odemeyeYetkiliMi = odemeyeYetkiliMi;
    }

    public boolean isMaasTanimlayabilirMi() {
        return maasTanimlayabilirMi;
    }

    public void setMaasTanimlayabilirMi(boolean maasTanimlayabilirMi) {
        this.maasTanimlayabilirMi = maasTanimlayabilirMi;
    }

    public boolean isIstenCikarabilirMi() {
        return istenCikarabilirMi;
    }

    public void setIstenCikarabilirMi(boolean istenCikarabilirMi) {
        this.istenCikarabilirMi = istenCikarabilirMi;
    }

    @Override
    public String toString() {
        return "Standart Personel" + '\n'
                + "Adı - Soyadı -> " + adSoyad + '\n'
                + "Yaşı -> " + yas + '\n'
                + "Telefonu -> " + telefon + '\n'
                + "Departmanı -> " + departman.getAd() + '\n'
                + "Maaşı -> " + maas + " TL" + '\n'
                + "Yetkileri -> Yok\n";
    }
}
