package com.yavuzavci.entity;

import static com.yavuzavci.utility.StaticValues.departmanListesi;

public class GenelMudur extends Mudur {

    public GenelMudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                      boolean odemeyeYetkiliMi, boolean maasTanimlayabilirMi, boolean istenCikarabilirMi) {
        super(adSoyad,cinsiyet,yas,telefon,departman,maasTanimlayabilirMi,istenCikarabilirMi);
        setDepartmanlar(departmanListesi.values().stream().toList());
        setOdemeyeYetkiliMi(odemeyeYetkiliMi);
    }

    public GenelMudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                      Double maas, boolean odemeyeYetkiliMi, boolean maasTanimlayabilirMi, boolean istenCikarabilirMi) {
        super(adSoyad,cinsiyet,yas,telefon,departman,maas,maasTanimlayabilirMi,istenCikarabilirMi);
        setDepartmanlar(departmanListesi.values().stream().toList());
        setOdemeyeYetkiliMi(odemeyeYetkiliMi);
    }

    @Override
    public String toString() {
        return "Genel Müdür" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı -> " + getYas() + '\n'
                + "Telefonu -> " + getTelefon() + '\n'
                + "Maaşı -> " + getMaas() + " TL" + '\n'
                + "Yetkileri -> "
                + (isOdemeyeYetkiliMi()
                    ? "Ödeme Yapma, "
                    : "")
                + (isMaasTanimlayabilirMi()
                    ? "Maaş Tanımlama, "
                    : "")
                + (isIstenCikarabilirMi()
                    ? "İşten Çıkarma\n"
                    : "\n")
                + "Bağlı Departmanlar -> " + getDepartmanlar()
                + '\n';
    }
}
