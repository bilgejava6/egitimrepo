package com.volkangenel.odev.repository.entity;

import java.util.List;

public class Mudur extends Personel {
    public int maasekodeme;
    List <String> gorevalanlari;
    List <String> baglipersoneller;

    public Mudur(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, int maasekodeme, List<String> gorevalanlari, List<String> baglipersoneller) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.maasekodeme = maasekodeme;
        this.gorevalanlari = gorevalanlari;
        this.baglipersoneller = baglipersoneller;
    }

    @Override
    public String toString() {
        return "Mudur{" +
                "maasekodeme=" + maasekodeme +
                ", gorevalanlari=" + gorevalanlari +
                ", baglipersoneller=" + baglipersoneller +
                '}';
    }

    public int getMaasekodeme() {
        return maasekodeme;
    }

    public void setMaasekodeme(int maasekodeme) {
        this.maasekodeme = maasekodeme;
    }

    public List<String> getGorevalanlari() {
        return gorevalanlari;
    }

    public void setGorevalanlari(List<String> gorevalanlari) {
        this.gorevalanlari = gorevalanlari;
    }

    public List<String> getBaglipersoneller() {
        return baglipersoneller;
    }

    public void setBaglipersoneller(List<String> baglipersoneller) {
        this.baglipersoneller = baglipersoneller;
    }
}
