package com.beratacer.repository;

import com.beratacer.repository.entity.Personel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonelRepository implements ICrud<Personel>{
    private List<Personel> personelListesi;

    public PersonelRepository() {
        this.personelListesi = new ArrayList<>();
    }

    @Override
    public void save(Personel personel) {
        personelListesi.add(personel);
    }

    @Override
    public void update(Long id,Personel personel) {
        for (int i = 0; i< personelListesi.size(); i++){
            if (personelListesi.get(i).getId()==id){
                personelListesi.set(i,personel);
            }
        }
    }

    @Override
    public List<Personel> findAll() {
        return personelListesi;
    }

    @Override
    public Optional<Personel> findById(Long id) {
        return personelListesi.stream()
                .filter(x-> x.getId()==id).findFirst();
    }
    public Optional<Personel> findByTcNo(String tcNo){
        return  personelListesi.stream()
                .filter(x-> x.getTcNo().equals(tcNo)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i< personelListesi.size(); i++){
            if (personelListesi.get(i).getId()==id){
                personelListesi.remove(i);
            }
        }
    }
}
