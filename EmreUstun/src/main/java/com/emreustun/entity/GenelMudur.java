package com.emreustun.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenelMudur extends Personel{
    private String gorevTanimi;
    private List<Departman> genelMudurlerinSorumluOlduguDepartmanListesi;

    public List<Departman> getGenelMudurlerinSorumluOlduguDepartmanListesi() {
        return genelMudurlerinSorumluOlduguDepartmanListesi;
    }

    public void setGenelMudurlerinSorumluOlduguDepartmanListesi(List<Departman> genelMudurlerinSorumluOlduguDepartmanListesi) {
        this.genelMudurlerinSorumluOlduguDepartmanListesi = genelMudurlerinSorumluOlduguDepartmanListesi;
    }

    public GenelMudur() {
        genelMudurlerinSorumluOlduguDepartmanListesi = new ArrayList<>();
    }

    public String getGorevTanimi() {
        return gorevTanimi;
    }

    public void setGorevTanimi(String gorevTanimi) {
        this.gorevTanimi = gorevTanimi;
    }
}
