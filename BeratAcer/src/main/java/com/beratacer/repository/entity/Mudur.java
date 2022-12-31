package com.beratacer.repository.entity;

import java.util.List;

public class Mudur extends Personel{
    private List<Departman> departmanListesi;

    public Mudur(String adSoyad, String telNo, String tcNo, String adres,
                 Departman departman, String iseBaslamaTarihi,List<Departman> departmanListesi) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);
        this.departmanListesi = departmanListesi;
    }

    public List<Departman> getDepartmanListesi() {
        return departmanListesi;
    }

    public void setDepartmanListesi(List<Departman> departmanListesi) {
        this.departmanListesi = departmanListesi;
    }
    @Override
    public String toString() {
        return super.toString() +
                "departmanListesi=" + departmanListesi +
                '}';
    }
}
