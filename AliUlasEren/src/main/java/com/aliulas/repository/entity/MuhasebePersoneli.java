package com.aliulas.repository.entity;

public class MuhasebePersoneli extends Personel{
    private String muhasebeAlani;
    public MuhasebePersoneli() {
        super();

    }

    public MuhasebePersoneli(String ad, String soyad, String email, String telefon, Departman departman, String pozisyon, int maas, String kayitTarihi, String muhasebeAlani) {
        super(ad, soyad, email, telefon, departman, pozisyon, maas, kayitTarihi);
        this.muhasebeAlani = muhasebeAlani;
    }

    public String getMuhasebeAlanı() {
        return muhasebeAlani;
    }

    public void setMuhasebeAlanı(String muhasebeAlanı) {
        this.muhasebeAlani = muhasebeAlanı;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli [muhasebeAlanı=" + muhasebeAlani + ", calismaYılı=" +  "]";
    }
}
