package com.aliakkulah.repository;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Mudur;
import com.aliakkulah.entity.Personel;

import static com.aliakkulah.utility.Utility.*;

import java.util.*;
import java.util.stream.Collectors;

public class PersonelRepository implements ICrud<Personel>{

    @Override
    public void save(Personel personel) {personelListesi.add(personel);}

    /**
     * Not id hiç bir zaman update edilmeyeceği varsayılmıştır.
     */
    @Override
    public void update(Personel personel) {
        Long id = personel.getId();
        for(int i = 0; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId().equals(id)) {
                personelListesi.set(i,personel);
            }
        }
    }

    @Override
    public void delete(Personel personel) {
        personel.getDepartman().getPersonelList().remove(personel);
        personelListesi.remove(personel);
    }

    @Override
    public List<Personel> findAll() {return personelListesi;}

    @Override
    public void findById(Long id) {
        boolean control = false;
        for (Personel personel : personelListesi) {
            if (personel.getId() == id) {
                System.out.println(personel);
                control = true;
            }
        }
        if(!control) {
            System.out.println("Boyle id'ye sahip bir personel bulunmamaktadir.");
        }
    }

    @Override
    public void deleteById(Long id) {
        boolean silindimi = false;
        for(int i = 0; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId().equals(id)) {
                personelListesi.get(i).getDepartman().getPersonelList().remove(personelListesi.get(i));
                personelListesi.remove(i);
                System.out.println("Personel basarili bir sekilde silinmistir.");
                silindimi = true;
                break;
                }
            }
        if(!silindimi)
            System.out.println("Boyle id'ye sahip bir personel bulunmamaktadir.");
    }

    @Override
    public Map<String,Double> odemeListesi() {
        Map<String,Double> odemeListesi = new TreeMap<>();
        personelListesi.forEach(x-> odemeListesi.put("id: " + x.getId() + " Isım Soyisim:" + x.getAd()+" "+x.getSoyad(), x.getMaas()));
        return odemeListesi;
    }

    public void siraliPersonelListesi(){personelListesi.forEach(System.out::println);}
    public void ayniGunBaslayanlarListesi() {
        Map<String, List<Personel>> ayniGunBaslayanlarMap= personelListesi.stream().collect(Collectors.groupingBy(Personel::getIseGirisTarihi));
        ayniGunBaslayanlarMap.forEach((x,y)->{
            System.out.println(x + " tarihinde ise baslayanlar:");
            y.forEach(z->
                    System.out.println(z.getAd() + " " + z.getSoyad())
            );
        });
    }
    public void mudureSorumluOlduguDepartmanEkle(Mudur mudur, Departman departman) {
        boolean control = false;
        for(int i = 0; i < mudur.getSorumluOlduguDepartmanlar().size(); i++){
            if(mudur.getSorumluOlduguDepartmanlar().get(i).equals(departman))
                control = true;
            break;
        }
        if(control)
            System.out.println("Eklenmek istenen departman zaten tanimli.");
        else {
            mudur.getSorumluOlduguDepartmanlar().add(departman);
            System.out.println("Departman eklendi.");
        }
    }
    public void mudurlerinSorumluOlduguDepartmanlar() {
        List<Personel> mudurler = new ArrayList<>();
        for(Departman departman : departmanListesi){
            if(departman.getAd().equalsIgnoreCase("Mudur"))
                mudurler = departman.getPersonelList();
        }
        for(int i = 0; i < mudurler.size(); i++) {
            Mudur mudur = (Mudur) mudurler.get(i);
            System.out.println((i + 1) + ". Mudur: " + mudur.getAd() + " " + mudur.getSoyad() + "'nın departmanları:");
            mudur.getSorumluOlduguDepartmanlar().forEach(System.out::println);
        }
    }
}