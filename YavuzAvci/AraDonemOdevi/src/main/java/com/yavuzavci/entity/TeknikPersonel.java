package com.yavuzavci.entity;

public class TeknikPersonel extends Personel {
    private Integer vardiyaSuresi;
    private String teknikAlan;
    public TeknikPersonel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                          Integer vardiyaSuresi, String teknikAlan) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        this.vardiyaSuresi = vardiyaSuresi;
        this.teknikAlan = teknikAlan;
    }

    public TeknikPersonel(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                          Double maas, Integer vardiyaSuresi, String teknikAlan) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        this.vardiyaSuresi = vardiyaSuresi;
        this.teknikAlan = teknikAlan;
    }

    public Integer getVardiyaSuresi() {
        return vardiyaSuresi;
    }

    public void setVardiyaSuresi(Integer vardiyaSuresi) {
        this.vardiyaSuresi = vardiyaSuresi;
    }

    public String getTeknikAlan() {
        return teknikAlan;
    }

    public void setTeknikAlan(String teknikAlan) {
        this.teknikAlan = teknikAlan;
    }

    @Override
    public String toString() {
        return "Teknik Personel" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı -> " + getYas() + '\n'
                + "Telefonu -> " + getTelefon() + '\n'
                + "Departmanı -> " + getDepartman().getAd() + '\n'
                + "Maaşı -> " + getMaas() + " TL" + '\n'
                + "Yetkileri -> Yok"
                + "Vardiya Süresi -> " + vardiyaSuresi + " Saat" + '\n'
                + "Alanı -> " + teknikAlan
                + '\n';
    }
}
