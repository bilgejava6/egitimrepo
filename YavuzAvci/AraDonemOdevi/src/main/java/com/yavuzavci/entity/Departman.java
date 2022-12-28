package com.yavuzavci.entity;

import java.util.ArrayList;
import java.util.List;

public class Departman extends BaseEntity {
    private String ad;
    private List<Personel> personelListesi;

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

    public List<Personel> getPersonelListesi() {
        return personelListesi;
    }

    public void setPersonelListesi(List<Personel> personelListesi) {
        this.personelListesi = personelListesi;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "ad='" + ad + '\'' +
                ", calisanSayisi=" + personelListesi.size() +
                '}';
    }
}
