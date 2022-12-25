package com.emreustun.entity;

import java.util.List;

public class Mudur extends Personel{
    List<Departman> sorumluOlduguDepartmanlar;

    public Mudur(String isim, int maas, int yas, ECinsiyet cinsiyet, String egitimSeviyesi, Departman departman, List<Departman> sorumluOlduguDepartmanlar) {
        super(isim, maas, yas, cinsiyet, departman);
        this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;
    }

    @Override
    public String toString() {
        return "Mudur{" +
                "sorumluOlduguDepartmanlar=" + sorumluOlduguDepartmanlar +
                '}';
    }

    public List<Departman> getSorumluOlduguDepartmanlar() {
        return sorumluOlduguDepartmanlar;
    }

    public void setSorumluOlduguDepartmanlar(List<Departman> sorumluOlduguDepartmanlar) {
        this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;
    }
}
