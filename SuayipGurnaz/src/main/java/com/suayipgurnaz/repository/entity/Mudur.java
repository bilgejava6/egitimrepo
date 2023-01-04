package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Mudur extends Personel{
    private Set<Departman> sorumluOlduguDepartmanlar;

    public Mudur(String ad, String iseBaslamaTarihi, Set<Departman> mudurSorumlulukList) {
        super();
        sorumluOlduguDepartmanlar = new LinkedHashSet<>();
        this.sorumluOlduguDepartmanlar=mudurSorumlulukList;
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
        this.setDepartman("YONETICI");
    }

    public Mudur(String ad, String iseBaslamaTarihi, double maas) {
        sorumluOlduguDepartmanlar = new LinkedHashSet<>();
        this.setId(StaticValues.personlerIdOlustur());
    }

    public Mudur() {
        
    }

    public Set<Departman> getSorumluOlduguDepartmanlar() {
        return sorumluOlduguDepartmanlar;
    }
    public void setSorumluOlduguDepartmanlar(Set<Departman> sorumluOlduguDepartmanlar) {
        this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;
    }

    @Override
    public String toString() {
        return "Mudur [sorumluOlduguDepartmanlar=" + sorumluOlduguDepartmanlar + ", toString()=" + super.toString()
                + "]";
    }
}
