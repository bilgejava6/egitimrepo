package com.yavuzavci.entity;

import static com.yavuzavci.utility.StaticValues.DEPARTMAN_LISTESI;

/**
 * Genel müdür sınıfı.
 * <br>
 * <br>
 * Genel müdür departmanların tümünden sorumludur. Genel müdür
 * işten çıkarılamaz ve sistemden silinemez. Genel müdürün
 * yetkileri tamdır.
 * <br>
 * <br>
 * Sistemde yalnızca 1 genel müdür olması isteniyorsa, genel müdürün
 * kendi isteğiyle işten çıkması ve/veya bilgilerinin silinmesi isteniyorsa
 * ve genel müdürün değiştirilebilmesi isteniyorsa bu sınıfı ve ilgili
 * katmanları değiştirin
 *
 * @author Yavuz AVCI
 */
public class GenelMudur extends Mudur {

    public GenelMudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                      boolean odemeyeYetkiliMi, boolean maasTanimlayabilirMi, boolean istenCikarabilirMi) {
        super(adSoyad,cinsiyet,yas,telefon,departman,maasTanimlayabilirMi,istenCikarabilirMi);
        setDepartmanlar(DEPARTMAN_LISTESI.values().stream().toList());
        setOdemeyeYetkiliMi(odemeyeYetkiliMi);
    }

    public GenelMudur(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon, Departman departman,
                      Double maas, boolean odemeyeYetkiliMi, boolean maasTanimlayabilirMi, boolean istenCikarabilirMi) {
        super(adSoyad,cinsiyet,yas,telefon,departman,maas,maasTanimlayabilirMi,istenCikarabilirMi);
        setDepartmanlar(DEPARTMAN_LISTESI.values().stream().toList());
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
