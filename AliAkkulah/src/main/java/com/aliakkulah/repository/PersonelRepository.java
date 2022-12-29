package com.aliakkulah.repository;

import com.aliakkulah.entity.Personel;

import static com.aliakkulah.utility.Utility.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PersonelRepository implements ICrud<Personel>{

    @Override
    public void save(Personel personel) {
        personelListesi.add(personel);
    }

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
        System.out.println("Boyle id'ye sahip bir personel bulunmamaktadir.");
    }

    @Override
    public void delete(Personel personel) {
        personelListesi.remove(personel);
    }

    @Override
    public List<Personel> findAll() {
        return personelListesi;
    }

    @Override
    public Personel findById(Long id) {
        for(int i = 0; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId().equals(id))
                return personelListesi.get(i);
        }
        System.out.println("Boyle id'ye sahip bir personel bulunmamaktadir.");
        return null;
    }

    @Override
    public void deleteById(Long id) {
        for(int i = 0; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId().equals(id)) {
                personelListesi.remove(i);
                System.out.println("Personel basarili bir sekilde silinmistir.");
            }
        }
        System.out.println("Boyle id'ye sahip bir personel bulunmamaktadir.");
    }

    @Override
    public Map<String,Double> odemeListesi() {
        Map<String,Double> odemeListesi = new TreeMap<>();
        personelListesi.forEach(x-> {
            odemeListesi.put("id: " + x.getId() + " Isım Soyisim:" + x.getAd()+" "+x.getSoyad(), x.getMaas());
        });
        return odemeListesi;
    }
}