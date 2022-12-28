package com.aliulas.repository.entity;

public class TeknikPersonel extends Personel{
    private String bilgiSeviyesi;
    public TeknikPersonel() {

    }

    public TeknikPersonel(String ad, String soyad, String email, String telefon,  String pozisyon, int maas, String kayitTarihi, String bilgiSeviyesi) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi);
        this.bilgiSeviyesi = bilgiSeviyesi;
    }

    public TeknikPersonel(String bilgiSeviyesi) {
        super();
        this.bilgiSeviyesi = bilgiSeviyesi;
    }




    public String getBilgiSeviyesi() {
        return bilgiSeviyesi;
    }



    public void setBilgiSeviyesi(String bilgiSeviyesi) {
        this.bilgiSeviyesi = bilgiSeviyesi;
    }



    @Override
    public String toString() {
        return "TeknikPersonel [bilgiSeviyesi=" + bilgiSeviyesi + "]";
    }







}
