package com.yavuzavci.entity;

/**
 * İnsan kaynakları personeli sınıfı.
 * <br>
 * <br>
 * Muhasebe personelleri gibi insan kaynakları personellerinin
 * de maaş tanımlama yetkileri vardır fakat ödeme yekileri
 * tanımlanmamıştır. İnsan kaynakları personeli için ödeme
 * yetkisi tanımlanmak isteniyorsa {@code MuhasebePersoneli}
 * sınıfındaki gibi tanımlanabilir.
 *
 * @author Yavuz AVCI
 */
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
