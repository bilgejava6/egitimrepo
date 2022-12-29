package com.yavuzavci.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Departman müdürleri sınıfı.
 * <br>
 * <br>
 * Her müdürün sorumlu olduğu departmanların listesi vardır.
 * Varsayılan olarak her müdürün personel maaşı tanımlama ve işten
 * çıkarma yetkisi vardır. Eğer müdürler için ödeme yetkisi tanımlanmak
 * istenirse bu sınıfı ve bu sınıfla ilgili katmanları değiştirin.
 *
 * @author Yavuz AVCI
 */
public class Mudur extends Personel {
    private List<Departman> departmanlar;

    public Mudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                 boolean maasTanimlayaBilirMi, boolean istenCikarabilirMi) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        departmanlar = new ArrayList<>();
        setMaasTanimlayabilirMi(maasTanimlayaBilirMi);
        setIstenCikarabilirMi(istenCikarabilirMi);
    }

    public Mudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon,
                 Departman departman, Double maas, boolean maasTanimlayaBilirMi, boolean istenCikarabilirMi) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        departmanlar = new ArrayList<>();
        setMaasTanimlayabilirMi(maasTanimlayaBilirMi);
        setIstenCikarabilirMi(istenCikarabilirMi);
    }

    public List<Departman> getDepartmanlar() {
        return departmanlar;
    }

    public void setDepartmanlar(List<Departman> departmanlar) {
        this.departmanlar = departmanlar;
    }

    @Override
    public String toString() {
        return "Müdür" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı ->  " + getYas() + '\n'
                + "Telefonu -> '" + getTelefon() + '\n'
                + "Departmanı ->  " + getDepartman().getAd() + '\n'
                + "Maaşı ->  " + getMaas() + " TL" + '\n'
                + "Yetkileri ->  "
                + (isMaasTanimlayabilirMi()
                    ? "Maaş Tanımlama, "
                    : "")
                + (isIstenCikarabilirMi()
                    ? "İşten Çıkarma\n"
                    : "\n")
                + "Bağlı Departmanlar -> " + departmanlar
                + '\n';
    }
}
