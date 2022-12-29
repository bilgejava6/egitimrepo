package com.yavuzavci.entity;

public class InsanKaynaklariPersoneli extends Personel {

    public InsanKaynaklariPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon,
                                    Departman departman, boolean maasTanimlayabilirMi) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        setMaasTanimlayabilirMi(maasTanimlayabilirMi);
    }

    public InsanKaynaklariPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon,
                                    Departman departman, Double maas, boolean maasTanimlayabilirMi) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        setMaasTanimlayabilirMi(maasTanimlayabilirMi);
    }

    @Override
    public String toString() {
        return "Büro Personeli" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı ->  " + getYas() + '\n'
                + "Telefonu -> '" + getTelefon() + '\n'
                + "Departmanı ->  " + getDepartman().getAd() + '\n'
                + "Maaşı ->  " + getMaas() + " TL" + '\n'
                + "Yetkileri ->  "
                + (isMaasTanimlayabilirMi()
                    ? "Maaş Tanımlama, "
                    : "")
                + '\n';
    }
}
