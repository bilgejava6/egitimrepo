package com.yavuzavci.entity;

import java.util.ArrayList;
import java.util.List;

public class Departman extends BaseEntity {
    private String ad;
    private int calisanSayisi;
    private List<Personel> personelListesi;

    public Departman() {
        super();
        personelListesi = new ArrayList<>();
    }

    public Departman(String ad){
        super();
        this.ad = ad;
        personelListesi = new ArrayList<>();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getCalisanSayisi() {
        return calisanSayisi;
    }

    public void setCalisanSayisi(int calisanSayisi) {
        this.calisanSayisi = calisanSayisi;
    }

    public List<Personel> getPersonelListesi() {
        return personelListesi;
    }

    public void setPersonelListesi(List<Personel> personelListesi) {
        this.personelListesi = personelListesi;
    }
}
