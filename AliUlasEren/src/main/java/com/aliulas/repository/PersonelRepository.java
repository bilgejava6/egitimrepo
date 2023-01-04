package com.aliulas.repository;

import com.aliulas.repository.entity.Personel;


import java.util.ArrayList;
import java.util.List;

public class PersonelRepository implements ICrudD<Personel> {
    private List<Personel> personelListesi;

    public PersonelRepository(){
        personelListesi = new ArrayList<>();
    }

    public List<Personel> getPersonelListesi() {
        return personelListesi;
    }

    public void setPersonelListesi(List<Personel> personelListesi) {
        this.personelListesi = personelListesi;
    }


    @Override
    public void save(Personel personel) {
        personelListesi.add(personel);
    }

    @Override
    public void update(Personel personel) {
        for(int i = 0 ; i < personelListesi.size();i++) {
            if(personelListesi.get(i).getId()== personel.getId()){
                personelListesi.set(i,personel);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for(int i = 0 ; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId()== (id)){
                personelListesi.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Personel> findAll() {
        return personelListesi;
    }

    @Override
    public Personel findById(Long id) {
        for(int i =0;i<personelListesi.size();i++) {
            if(personelListesi.get(i).getId()== id)
                return personelListesi.get(i);
        }
        return null;
    }
}