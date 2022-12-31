package com.aliulas.repository.entity;

import java.util.List;

public class GenelMudur extends Personel {
    private String sorumluOlduguDepartmanlar;

    public GenelMudur() {
    }

    public GenelMudur(String ad, String soyad, String email, String telefon, String pozisyon, int maas, String kayitTarihi, String sorumluOlduguAlanlar,String departman) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi,departman);
        this.sorumluOlduguDepartmanlar = sorumluOlduguAlanlar;
    }

    public String getSorumluOlduguAlanlar() {
        return sorumluOlduguDepartmanlar;
    }

    public void setSorumluOlduguAlanlar(String sorumluOlduguAlanlar) {
        this.sorumluOlduguDepartmanlar = sorumluOlduguAlanlar;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "sorumluOlduguAlanlar='" + sorumluOlduguDepartmanlar + '\'' +
                "} " + super.toString();
    }
}


