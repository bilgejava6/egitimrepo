package com.yavuzavci.entity;

/**
 * Aksi tercih edilmedikçe oluşturabileceğimiz
 * varsayılan personel türü.
 */
public class BuroPersoneli extends Personel {

    public BuroPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
    }

    public BuroPersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman, Double maas) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
    }

    @Override
    public String toString() {
        return "Büro Personeli" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı -> " + getYas() + '\n'
                + "Telefonu -> " + getTelefon() + '\n'
                + "Departmanı -> " + getDepartman().getAd() + '\n'
                + "Maaşı -> " + getMaas() + " TL" + '\n'
                + "Yetkileri -> Yok"
                + '\n';
    }
}
