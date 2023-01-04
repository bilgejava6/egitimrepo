package com.volkangenel.odev.repository.entity;

public class GenelMudur extends Personel {
    private int sirkethissePayi;

    public GenelMudur(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, int sirkethissePayi) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.sirkethissePayi = sirkethissePayi;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "sirkethissePayi=" + sirkethissePayi +
                '}';
    }

    public int getSirkethissePayi() {
        return sirkethissePayi;
    }

    public void setSirkethissePayi(int sirkethissePayi) {
        this.sirkethissePayi = sirkethissePayi;
    }
}
