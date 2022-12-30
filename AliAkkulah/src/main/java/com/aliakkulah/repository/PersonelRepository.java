package com.aliakkulah.repository;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Personel;

import static com.aliakkulah.utility.Utility.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        personel.getDepartman().getPersonelList().remove(personel);
        personelListesi.remove(personel);
    }

    @Override
    public List<Personel> findAll() {
        return personelListesi;
    }

    @Override
    public Personel findById(Long id) {
        for (Personel personel : personelListesi) {
            if (personel.getId().equals(id))
                return personel;
        }
        System.out.println("Boyle id'ye sahip bir personel bulunmamaktadir.");
        return null;
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

    public void siraliPersonelListesi(){
        personelListesi.forEach(System.out::println);
    }

    public void ayniGunBaslayanlarListesi() {
        Map<String, List<Personel>> ayniGunBaslayanlarMap= personelListesi.stream().collect(Collectors.groupingBy(Personel::getIseGirisTarihi));
        ayniGunBaslayanlarMap.forEach((x,y)->{
            System.out.println(x + " tarihinde ise baslayanlar:");
            y.forEach(z->
                    System.out.println(z.getAd() + " " + z.getSoyad())
            );
        });
    }
}