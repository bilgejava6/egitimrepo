package com.aliulas.repository.entity;

import java.util.List;

public class GenelMudur extends Personel {
    private String sorumluOlduguAlanlar;

    public GenelMudur() {
    }

    public GenelMudur(String ad, String soyad, String email, String telefon, String pozisyon, int maas, String kayitTarihi, String sorumluOlduguAlanlar) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi);
        this.sorumluOlduguAlanlar = sorumluOlduguAlanlar;
    }

    public String getSorumluOlduguAlanlar() {
        return sorumluOlduguAlanlar;
    }

    public void setSorumluOlduguAlanlar(String sorumluOlduguAlanlar) {
        this.sorumluOlduguAlanlar = sorumluOlduguAlanlar;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "sorumluOlduguAlanlar='" + sorumluOlduguAlanlar + '\'' +
                "} " + super.toString();
    }
}


