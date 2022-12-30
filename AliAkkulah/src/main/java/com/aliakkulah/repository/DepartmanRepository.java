package com.aliakkulah.repository;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Personel;

import static com.aliakkulah.utility.Utility.*;

import java.util.ArrayList;
import java.util.List;

public class DepartmanRepository {

    public void save(Departman departman) {
        departmanListesi.add(departman);
    }

    public List<Departman> findAll() {
        return departmanListesi;
    }

    public List<Personel> departmanPersonelListesi(Departman departman) {
        return departman.getPersonelList();
    }

    public List<Departman> enCokPersonelliDepartman() {
        List<Departman> maxDepartmanlar = new ArrayList<>();
        int maxPersonelSayisi = -1;
        for (Departman departman : departmanListesi) {
            int personelSayisi = departman.getPersonelList().size();
            if (personelSayisi > maxPersonelSayisi) {
                maxDepartmanlar.clear();
                maxDepartmanlar.add(departman);
                maxPersonelSayisi = personelSayisi;
            } else if (personelSayisi == maxPersonelSayisi) {
                maxDepartmanlar.add(departman);
            }
        }
        return maxDepartmanlar;
    }
}