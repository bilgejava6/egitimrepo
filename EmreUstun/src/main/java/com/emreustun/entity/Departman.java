package com.emreustun.entity;

import java.util.ArrayList;
import java.util.List;

public class Departman {


    private Personel personel;
    private String ad;
    private int vardiyaSayisi;
    private List<Personel> departmanPersonelListesi;

    public List<Personel> getDepartmanPersonelListesi() {
        return departmanPersonelListesi;
    }

    public void setDepartmanPersonelListesi(List<Personel> departmanPersonelListesi) {
        this.departmanPersonelListesi = departmanPersonelListesi;
    }

    public int getVardiyaSayisi() {
        return vardiyaSayisi;
    }

    public void setVardiyaSayisi(int vardiyaSayisi) {
        this.vardiyaSayisi = vardiyaSayisi;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "ad='" + ad + '\'' +
                '}';
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Departman() {
        departmanPersonelListesi = new ArrayList<>();
    }
    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

}
