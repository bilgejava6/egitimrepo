package com.aliulas.repository.entity;

public class TeknikPersonel extends Personel{
    private String bilgiSeviyesi;
    public TeknikPersonel() {

    }

    public TeknikPersonel(String ad, String soyad, String email, String telefon, Departman departman, String pozisyon, int maas, String kayitTarihi, String bilgiSeviyesi) {
        super(ad, soyad, email, telefon, departman, pozisyon, maas, kayitTarihi);
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
