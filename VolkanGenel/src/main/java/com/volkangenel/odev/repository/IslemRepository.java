package com.volkangenel.odev.repository;

import com.volkangenel.odev.repository.entity.Departman;
import com.volkangenel.odev.repository.entity.Mudur;
import com.volkangenel.odev.repository.entity.Personel;
import com.volkangenel.odev.repository.entity.utility.StaticValues;

import java.util.*;
import java.util.stream.Collectors;

public class IslemRepository {

    public void personelMaasiDuzenle(List<Double> maasListesi) {
        for (int i = 0; i< StaticValues.personelListesi.size(); i++) {
            StaticValues.personelListesi.get(i).setMaas(maasListesi.get(i));
        }
    }

    public ArrayList<Double> odemeListesi() {
        ArrayList<Double> odemeListesi = new ArrayList<>();
        for (int i =0; i<StaticValues.personelListesi.size();i++) {
           odemeListesi.add(StaticValues.personelListesi.get(i).getMaas());
        }
        return odemeListesi;
    }

    public Map<Departman,List<Personel>> departmanPersonelListesi() {
        Map<Departman,List<Personel>> departmanListMap = StaticValues.personelListesi.stream().collect(Collectors.groupingBy(Personel::getDepartman));
        return departmanListMap;
    }

    public String enCokPersonelBulunanDepartman () {
        int sayi=0;
        List<Personel> tempList = new ArrayList<>();
        Map<Departman,List<Personel>> departmanListMap = StaticValues.personelListesi.stream().collect(Collectors.groupingBy(Personel::getDepartman));
       Collection<List<Personel>> personelSet= departmanListMap.values();
        for (List<Personel> personellist:personelSet) {
            if (personellist.size()>sayi) {
                sayi = personellist.size();
                tempList = personellist;
            }
        }
        return tempList.get(0).getDepartman().getAd();
    }
    public Set<String> mudurSorumluluk () {
        List <Mudur> mudurler = new ArrayList<>();
        return null;
    }
    public Map<Long,List<Personel>> kayitTarihineGoreSirala() {
        Map<Long,List<Personel>> kayitTarihiListMap = StaticValues.personelListesi.stream().collect(Collectors.groupingBy(Personel::getCreateDate));
        return kayitTarihiListMap;
    }
}
