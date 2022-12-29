package com.yavuzavci.repository;

import com.yavuzavci.entity.Personel;

import java.util.List;

import static com.yavuzavci.utility.StaticValues.personelListesi;

public class PersonelRepository implements ICrud<Personel> {

    public PersonelRepository(){

    }

    @Override
    public void save(Personel personel) {
        personelListesi.add(personel);
        personel.getDepartman().getPersonelListesi().add(personel);
    }

    @Override
    public void update(Personel personel) {
        for(int i = 0 ; i < personelListesi.size();i++) {
            if(personelListesi.get(i).getId().equals(personel.getId())){
                personelListesi.set(i,personel);
                personel.getDepartman()
                        .getPersonelListesi()
                        .set(
                                personel.getDepartman().getPersonelListesi().indexOf(personel),
                                personel);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for(int i = 0 ; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId().equals(id)){
                personelListesi.remove(i);
                personelListesi.get(i).getDepartman()
                        .getPersonelListesi()
                        .remove(personelListesi.get(i));
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
            if(personelListesi.get(i).getId().equals(id))
                return personelListesi.get(i);
        }
        return null;
    }
}
