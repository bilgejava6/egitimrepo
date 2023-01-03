package com.volkangenel.odev.repository.entity;

public class BuroPersoneli extends Personel {
    private int solitaireSkoru;

    public BuroPersoneli(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, int solitaireSkoru) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.solitaireSkoru = solitaireSkoru;
    }

    public int getSolitaireSkoru() {
        return solitaireSkoru;
    }
    public void setSolitaireSkoru(int solitaireSkoru) {
        this.solitaireSkoru = solitaireSkoru;
    }

    @Override
    public String toString() {
        return "BuroPersoneli{" +
                "solitaireSkoru=" + solitaireSkoru +
                '}';
    }
}
