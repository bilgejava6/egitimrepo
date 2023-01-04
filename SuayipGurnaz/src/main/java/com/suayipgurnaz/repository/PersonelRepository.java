package com.suayipgurnaz.repository;

import com.suayipgurnaz.repository.entity.Departman;
import com.suayipgurnaz.repository.entity.Personel;

import java.util.List;

import static com.suayipgurnaz.utility.PtsUtility.personelList;

public class PersonelRepository implements ICrud<Personel>{
    @Override
    public void save(Personel t) {
    	Departman departman=t.getDepartman();
        departman.setPersonelSayisi(departman.getPersonelSayisi()+1);
        personelList.add(t);
    }

    @Override
    public void update(Personel t) {
        for (int i = 0; i < personelList.size(); i++) {
            if(personelList.get(i).getId().equals(t.getId())) {
                personelList.set(i, t);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < personelList.size(); i++) {
            if(personelList.get(i).getId().equals(id)){
                personelList.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Personel> findAll() {
        return personelList;
    }

    @Override
    public Personel findById(Long id) {
        for (int i = 0; i < personelList.size(); i++) {
            if(personelList.get(i).getId().equals(id)) {
                return personelList.get(i);
            }
        }
        return null;
    }
}
