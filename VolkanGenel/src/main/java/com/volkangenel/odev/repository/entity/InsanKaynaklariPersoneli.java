package com.volkangenel.odev.repository.entity;

public class InsanKaynaklariPersoneli extends Personel {
    private int mulakatSayisi;

    public InsanKaynaklariPersoneli(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, int mulakatSayisi) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.mulakatSayisi = mulakatSayisi;
    }

    @Override
    public String toString() {
        return "InsanKaynaklariPersoneli{" +
                "mulakatSayisi=" + mulakatSayisi +
                '}';
    }

    public int getMulakatSayisi() {
        return mulakatSayisi;
    }

    public void setMulakatSayisi(int mulakatSayisi) {
        this.mulakatSayisi = mulakatSayisi;
    }
}
