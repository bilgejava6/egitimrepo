package com.emreustun.repository;

import com.emreustun.entity.Personel;
import static com.emreustun.utility.StaticValues.*;

import java.util.List;

public class PersonelRepository implements ICrudPersonel<Personel> {
    @Override
    public void save(Personel personel) {
        personelListesi.add(personel);
    }

    @Override
    public void update(Personel personel) {
        for(int i = 0 ; i < personelListesi.size();i++) {
            if(personelListesi.get(i).getId() == personel.getId()){
                personelListesi.set(i,personel);
                break;
            }
        }
    }
    @Override
    public void delete(Long id) {
        for(int i = 0 ; i < personelListesi.size(); i++) {
            if(personelListesi.get(i).getId() == id){
                personelListesi.remove(i);
                break;
            }
        }

    }

    @Override
    public Personel findById(Long id) {
        for(int i =0;i<personelListesi.size();i++) {
            if(id == personelListesi.get(i).getId())
                return personelListesi.get(i);
        }
        return null;
    }

    @Override
    public List<Personel> findAll() {
        return personelListesi;
    }
}
