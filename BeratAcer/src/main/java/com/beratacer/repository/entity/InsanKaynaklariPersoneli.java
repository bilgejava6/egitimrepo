package com.beratacer.repository.entity;

public class InsanKaynaklariPersoneli extends Personel {
    private String iletisimBecerisi;

    public InsanKaynaklariPersoneli(String adSoyad, String telNo, String tcNo, String adres,
                                    Departman departman, String iseBaslamaTarihi, String iletisimBecerisi) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);
        this.iletisimBecerisi = iletisimBecerisi;
    }

    public String getIletisimBecerisi() {
        return iletisimBecerisi;
    }

    public void setIletisimBecerisi(String iletisimBecerisi) {
        this.iletisimBecerisi = iletisimBecerisi;
    }

    @Override
    public String toString() {
        return super.toString() +
                "iletisimBecerisi='" + iletisimBecerisi + '\'' +
                '}';
    }
}
