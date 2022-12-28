package com.aliulas.repository.entity;

public class InsanKaynaklariPersoneli extends Personel{
    private String calismaAlani;

    public InsanKaynaklariPersoneli(){

    }

    public InsanKaynaklariPersoneli(String ad, String soyad, String email, String telefon, Departman departman, String pozisyon, int maas, String kayitTarihi, String calismaAlani) {
        super(ad, soyad, email, telefon, departman, pozisyon, maas, kayitTarihi);
        this.calismaAlani = calismaAlani;
    }

    public InsanKaynaklariPersoneli(String calismaAlani) {
        super();
        this.calismaAlani = calismaAlani;
    }


    public String getCalismaAlanı() {
        return calismaAlani;
    }

    public void setCalismaAlanı(String calismaAlanı) {
        this.calismaAlani = calismaAlanı;
    }

    @Override
    public String toString() {
        return "InsanKaynaklariPersoneli [calismaAlanı=" + calismaAlani + ", calismaYılı=" + "]";
    }
}
