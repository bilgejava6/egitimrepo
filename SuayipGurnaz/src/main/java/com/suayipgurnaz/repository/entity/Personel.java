package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.PtsUtility;
import com.suayipgurnaz.utility.StaticValues;

public class Personel extends BaseEntity{
    private String ad;
    private String soyad;
    private String iseBaslamaTarihi;
    private String telefon;
    private String adres;
    private Departman departman;
    private double maas;

    public Personel() {
        this.setId(StaticValues.personlerIdOlustur());
    }

    public Personel(String ad, String iseBaslamaTarihi,  double maas) {
        this.ad = ad;
        this.iseBaslamaTarihi = iseBaslamaTarihi;
        this.maas = maas;
        this.setId(StaticValues.personlerIdOlustur());
    }

    public String getIseBaslamaTarihi() {
        return iseBaslamaTarihi;
    }

    public void setIseBaslamaTarihi(String iseBaslamaTarihi) {
        this.iseBaslamaTarihi = iseBaslamaTarihi;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(String departmanAdi) {
        for(int i=0; i< PtsUtility.departmanList.size(); i++){
            if(PtsUtility.departmanList.get(i).getAd().equalsIgnoreCase(departmanAdi)){
                this.departman = PtsUtility.departmanList.get(i);
                return;
            }
        }
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "Personel [ad=" + ad + ", soyad=" + soyad + ", departman=" + departman + ", maas=" + maas + "]";
    }
}
