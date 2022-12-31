package com.beratacer.repository.entity;

public class Hizmetli extends Personel{
    private String sorumlukAlani;

    public Hizmetli(String adSoyad, String telNo, String tcNo, String adres,
                    Departman departman, String iseBaslamaTarihi, String sorumluOlduguAlan) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);
        this.sorumlukAlani = sorumluOlduguAlan;
    }

    public String getSorumlukAlani() {
        return sorumlukAlani;
    }

    public void setSorumlukAlani(String sorumlukAlani) {
        this.sorumlukAlani = sorumlukAlani;
    }

    @Override
    public String toString() {

        return super.toString()+
                "sorumluOlduguAlan='" + sorumlukAlani + '\'' +
                '}';
    }
}
