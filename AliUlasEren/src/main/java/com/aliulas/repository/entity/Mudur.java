package com.aliulas.repository.entity;

public class Mudur extends Personel{
    private String sorumluOlduguDepartman;
    public Mudur() {
    }

    public Mudur(String ad, String soyad, String email, String telefon, String pozisyon, int maas, String kayitTarihi, String sorumluOlduguDepartman) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi);
        this.sorumluOlduguDepartman = sorumluOlduguDepartman;
    }

    public Mudur(String sorumluOlduguDepartman) {
        super();
        this.sorumluOlduguDepartman = sorumluOlduguDepartman;
    }


    public String getSorumluOlduguDepartman() {
        return sorumluOlduguDepartman;
    }

    public void setSorumluOlduguDepartman(String sorumluOlduguDepartman) {
        this.sorumluOlduguDepartman = sorumluOlduguDepartman;
    }
}
