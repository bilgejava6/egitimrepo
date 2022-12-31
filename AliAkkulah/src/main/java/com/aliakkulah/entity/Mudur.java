package com.aliakkulah.entity;

import java.util.ArrayList;
import java.util.List;

import static com.aliakkulah.utility.Utility.departmanListesi;
import static com.aliakkulah.utility.Utility.personelListesi;

public class Mudur extends Personel {
    private int bonusZamMiktari;
    private List<Departman> sorumluOlduguDepartmanlar;
    public Mudur(String ad, String soyad, String unvan, String iseGirisTarihi, int dogumYili, String cinsiyet, double maas, int depIndex, int bonusZamMiktari, List<Personel> sorumluOlduguCalisanlar) {
        super(ad, soyad, unvan, iseGirisTarihi, dogumYili, cinsiyet, maas, depIndex);
        this.bonusZamMiktari = bonusZamMiktari;
        this.sorumluOlduguDepartmanlar = new ArrayList<>();
    }
    public int getBonusZamMiktari() {return bonusZamMiktari;}
    public void setBonusZamMiktari(int bonusZamMiktari) {this.bonusZamMiktari = bonusZamMiktari;}
    public List<Departman> getSorumluOlduguDepartmanlar() {return sorumluOlduguDepartmanlar;}
    public void setSorumluOlduguDepartmanlar(List<Departman> sorumluOlduguDepartmanlar) {this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;}
    @Override
    public String toString() {
        return "Mudur [bonusZamMiktari=" + bonusZamMiktari + ", sorumluOlduguCalisanlar=" + sorumluOlduguDepartmanlar
                + "," + super.toString();
    }
}