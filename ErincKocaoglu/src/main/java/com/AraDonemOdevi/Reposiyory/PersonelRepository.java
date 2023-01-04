package com.AraDonemOdevi.Reposiyory;

import static com.AraDonemOdevi.Utility.PersonelUtility.*;

import com.AraDonemOdevi.Entity.Personel;


import java.util.Map;

public class PersonelRepository implements ICrud<Personel> {


    @Override
    public void save(Personel t) {
        personelListesi.put(t.getId(),t);

    }


    @Override
    public void update(Personel eskiPersonel, Personel yeniPersonel) {
        System.out.println( personelListesi.replace(eskiPersonel.getId(), eskiPersonel, yeniPersonel));
    }


    @Override
    public void delete(Personel p) {

        personelListesi.remove(p.getId());

    }

    @Override
    public Map<Long, Personel> findAll() {
        return personelListesi;
    }

    @Override
    public Personel findById(Long id) {
        return personelListesi.get(id);
    }

    @Override
    public void deleteById(Long id) {
        personelListesi.remove(id);
    }



}
