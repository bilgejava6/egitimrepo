package com.emreustun.entity;

import java.util.ArrayList;
import java.util.List;

public class Mudur extends Personel{
    private String gorevTanimi;
    private List<Departman> mudurlerinSorumluOlduguDepartmanListesi;
    public Mudur() {
        mudurlerinSorumluOlduguDepartmanListesi = new ArrayList<>();
    }

    public List<Departman> getMudurlerinSorumluOlduguDepartmanListesi() {
        return mudurlerinSorumluOlduguDepartmanListesi;
    }

    public void setMudurlerinSorumluOlduguDepartmanListesi(List<Departman> mudurlerinSorumluOlduguDepartmanListesi) {
        this.mudurlerinSorumluOlduguDepartmanListesi = mudurlerinSorumluOlduguDepartmanListesi;
    }

    public String getGorevTanimi() {
        return gorevTanimi;
    }

    public void setGorevTanimi(String gorevTanimi) {
        this.gorevTanimi = gorevTanimi;
    }
}
