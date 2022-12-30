package com.aliakkulah.repository;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Personel;

import static com.aliakkulah.utility.Utility.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    public void departmanaGoreMaasOrtalamalari(Departman departman) {
        Double avarageMaas = departman.getPersonelList().stream().collect(Collectors.averagingDouble(Personel::getMaas));
        System.out.println(departman.getAd() + " departmani personellerinin ortalama maasi = " + avarageMaas);
    }
}