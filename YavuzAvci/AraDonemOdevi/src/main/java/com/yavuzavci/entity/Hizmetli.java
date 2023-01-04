package com.yavuzavci.entity;

/**
 * Hizmetli personel sınıfı.
 * <br>
 * <br>
 * Teknik personeller gibi hizmetli personellerin
 * de vardiyaları vardır fakat sorumlu oldukları hizmet
 * alanı tanımlanmamıştır. Hizmetli personel için sorumlu
 * oldukları alan bilgisi tanımlanmak isteniyorsa
 * {@code TeknikPersonel} sınıfındaki gibi tanımlanabilir.
 *
 * @author Yavuz AVCI
 */
public class Hizmetli extends Personel {
    private Integer vardiyaSuresi;

    public Hizmetli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon,
                    Departman departman, Integer vardiyaSuresi) {
        super(adSoyad, cinsiyet, yas, telefon, departman);
        this.vardiyaSuresi = vardiyaSuresi;

    }

    public Hizmetli(String adSoyad, ECinsiyet cinsiyet, Integer yas, String telefon,
                    Departman departman, Double maas, Integer vardiyaSuresi) {
        super(adSoyad, cinsiyet, yas, telefon, departman, maas);
        this.vardiyaSuresi = vardiyaSuresi;
    }

    public Integer getVardiyaSuresi() {
        return vardiyaSuresi;
    }

    public void setVardiyaSuresi(Integer vardiyaSuresi) {
        this.vardiyaSuresi = vardiyaSuresi;
    }

    @Override
    public String toString() {
        return "Hizmetli" + '\n'
                + "Adı - Soyadı -> " + getAdSoyad() + '\n'
                + "Yaşı ->  " + getYas() + '\n'
                + "Telefonu -> '" + getTelefon() + '\n'
                + "Departmanı ->  " + getDepartman().getAd() + '\n'
                + "Maaşı ->  " + getMaas() + " TL" + '\n'
                + "Yetkileri -> Yok"
                + '\n';
    }
}
