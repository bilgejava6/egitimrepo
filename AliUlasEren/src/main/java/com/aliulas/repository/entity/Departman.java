package com.aliulas.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class Departman extends BaseEntity{
    private String ad;
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    private int calisanSayisi;
    private List<Personel> personelListesi;

    public Departman() {
        super();
        personelListesi = new ArrayList<>();
    }

    public Departman(Long id,String ad){
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
    @Override
    public String toString() {
        return "Departman{" +
                "ad='" + ad + '\'' +
                ", calisanSayisi=" + calisanSayisi +
                ", personelListesi=" + personelListesi.size() +
                "} "  ;
    }
}

