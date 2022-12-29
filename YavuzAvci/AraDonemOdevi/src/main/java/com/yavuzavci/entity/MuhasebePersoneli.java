package com.yavuzavci.entity;

public class MuhasebePersoneli extends Personel {

    public MuhasebePersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                             boolean odemeyeYetkiliMi, boolean maasTanimlayabilirMi) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        setOdemeyeYetkiliMi(odemeyeYetkiliMi);
        setMaasTanimlayabilirMi(maasTanimlayabilirMi);
    }

    public MuhasebePersoneli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                             Double maas, boolean odemeyeYetkiliMi, boolean maasTanimlayabilirMi) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        setOdemeyeYetkiliMi(odemeyeYetkiliMi);
        setMaasTanimlayabilirMi(maasTanimlayabilirMi);
    }

    @Override
    public String toString() {
        return "Muhasebe Personeli" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı -> " + getYas() + '\n'
                + "Telefonu -> " + getTelefon() + '\n'
                + "Departmanı -> " + getDepartman().getAd() + '\n'
                + "Maaşı -> " + getMaas() + " TL" + '\n'
                + "Yetkileri -> "
                + (isOdemeyeYetkiliMi()
                    ? "Ödeme Yapma, "
                    : "")
                + (isMaasTanimlayabilirMi()
                    ? "Maaş Tanımlama"
                    : "")
                + '\n';
    }
}
