package com.volkangenel.odev.repository;

import com.volkangenel.odev.repository.entity.Personel;


import java.util.List;

import static com.volkangenel.odev.repository.entity.utility.StaticValues.*;

public class PersonelRepository implements ICrud<Personel> {

    @Override
    public void save(Personel t) {
        personelListesi.add(t);
    }

    @Override
    public void update(Personel t) {
        for (int i = 0; i < personelListesi.size(); i++) {
            if (t.getId()==personelListesi.get(i).getId()) {
                personelListesi.set(i,t);
            }
        }
    }

    @Override
    public List<Personel> findAll() {
        return personelListesi;
    }

    @Override
    public Personel findById(Long id) {
        for (int i = 0; i < personelListesi.size(); i++) {
            if (personelListesi.get(i).getId().equals(id))
                return personelListesi.get(i);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i < personelListesi.size(); i++) {
            if (id==personelListesi.get(i).getId()) {
                personelListesi.remove(i);
            }
        }
    }
}
