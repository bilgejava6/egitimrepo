package com.aliulas.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class Departman extends BaseEntity{
    private String ad;
    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private List<Personel> personelListesi;

    public Departman() {
        super();
        personelListesi = new ArrayList<>();
    }

    public Departman(int id,String ad){
        super();
        this.id = id;
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
                ", personel sayısı=" + personelListesi.size() +
                "} "  ;
    }
}


