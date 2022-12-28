package com.emreustun.entity;

public abstract class Personel extends BaseEntity {
    private String adSoyad;
    private int maas;
    private int yas;
    private ECinsiyet cinsiyet;
    private Departman departman;

    public Personel() {
    }

    @Override
    public String toString() {
        return "Personel{" +
                "id= " + getId()+
                " isim soyisim='" + adSoyad + '\'' +
                ", maas=" + maas +
                ", yas=" + yas +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", departman=" + departman +
                '}';
    }
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setIsim(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public ECinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(ECinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }
}
