package com.beratacer.repository.entity;

public class TeknikPersonel extends Personel{
    private String sorumlulukAlani;
    private String teknikOzellik;

    public TeknikPersonel(String adSoyad, String telNo, String tcNo, String adres,
                          Departman departman, String iseBaslamaTarihi, String sorumlulukAlani, String teknikOzellik) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);
        this.sorumlulukAlani = sorumlulukAlani;
        this.teknikOzellik = teknikOzellik;
    }

    public String getSorumlulukAlani() {
        return sorumlulukAlani;
    }

    public void setSorumlulukAlani(String sorumlulukAlani) {
        this.sorumlulukAlani = sorumlulukAlani;
    }

    public String getTeknikOzellik() {
        return teknikOzellik;
    }

    public void setTeknikOzellik(String teknikOzellik) {
        this.teknikOzellik = teknikOzellik;
    }

    @Override
    public String toString() {
        return super.toString() +
                "sorumlulukAlani='" + sorumlulukAlani + '\'' +
                ", teknikOzellik='" + teknikOzellik + '\'' +
                '}';
    }
}
