package com.volkangenel.odev.repository.entity;

public class MuhasebePersoneli extends Personel {
    private String sorumlulukAlanı;

    public MuhasebePersoneli(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, String sorumlulukAlanı) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.sorumlulukAlanı = sorumlulukAlanı;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli{" +
                "sorumlulukAlanı='" + sorumlulukAlanı + '\'' +
                '}';
    }

    public String getSorumlulukAlanı() {
        return sorumlulukAlanı;
    }

    public void setSorumlulukAlanı(String sorumlulukAlanı) {
        this.sorumlulukAlanı = sorumlulukAlanı;
    }
}
