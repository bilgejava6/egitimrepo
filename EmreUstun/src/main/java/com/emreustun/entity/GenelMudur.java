package com.emreustun.entity;

import java.util.Arrays;
import java.util.List;

public class GenelMudur extends Personel{
    List<Departman> sorumluOlduguDepartmanlar;
    String [] yetkiAlanlari;

    public GenelMudur(String isim, String soyisim, int maas, int yas, ECinsiyet cinsiyet, String egitimSeviyesi, Departman departman, List<Departman> sorumluOlduguDepartmanlar, String[] yetkiAlanlari) {
        super(isim, maas, yas, cinsiyet, departman);
        this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;
        this.yetkiAlanlari = yetkiAlanlari;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "sorumluOlduguDepartmanlar=" + sorumluOlduguDepartmanlar +
                ", yetkiAlanlari=" + Arrays.toString(yetkiAlanlari) +
                '}';
    }

    public List<Departman> getSorumluOlduguDepartmanlar() {
        return sorumluOlduguDepartmanlar;
    }

    public void setSorumluOlduguDepartmanlar(List<Departman> sorumluOlduguDepartmanlar) {
        this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;
    }

    public String[] getYetkiAlanlari() {
        return yetkiAlanlari;
    }

    public void setYetkiAlanlari(String[] yetkiAlanlari) {
        this.yetkiAlanlari = yetkiAlanlari;
    }
}
