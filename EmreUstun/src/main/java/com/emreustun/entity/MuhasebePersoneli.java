package com.emreustun.entity;

public class MuhasebePersoneli extends Personel{
    String gorev;

    public MuhasebePersoneli(String isim, int maas, int yas, ECinsiyet cinsiyet, String egitimSeviyesi, Departman departman, String gorev) {
        super(isim, maas, yas, cinsiyet, departman);
        this.gorev = gorev;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli{" +
                "gorev='" + gorev + '\'' +
                '}';
    }
}
