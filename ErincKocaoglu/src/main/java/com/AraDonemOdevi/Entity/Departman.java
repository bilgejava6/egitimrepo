package com.AraDonemOdevi.Entity;


public class Departman extends BaseDepartmanEntity {

    String ad;
    int personelSayisi;


    @Override
    public String toString() {
        return "Personel{" +
                "ad='" + ad + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public Departman() {
        //System.out.println(id);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getPersonelSayisi() {
        return personelSayisi;
    }

    public void setPersonelSayisi(int personelSayisi) {
        this.personelSayisi = personelSayisi;
    }
}
