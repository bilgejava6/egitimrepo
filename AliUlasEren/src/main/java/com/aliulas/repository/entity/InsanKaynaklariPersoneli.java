package com.aliulas.repository.entity;

public class InsanKaynaklariPersoneli extends Personel{
    private String calismaAlani;

    public InsanKaynaklariPersoneli(){

    }

    public InsanKaynaklariPersoneli(String ad, String soyad, String email, String telefon, String pozisyon, int maas, String kayitTarihi, String calismaAlani,String departman) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi,departman);
        this.calismaAlani = calismaAlani;
    }

    public InsanKaynaklariPersoneli(String calismaAlani) {
        super();
        this.calismaAlani = calismaAlani;
    }


    public String getCalismaAlani() {
        return calismaAlani;
    }

    public void setCalismaAlani(String calismaAlani) {
        this.calismaAlani = calismaAlani;
    }

    @Override
    public String toString() {
        return "InsanKaynaklariPersoneli [calismaAlani=" + calismaAlani + ", calismaYili=" + "]";
    }
}
