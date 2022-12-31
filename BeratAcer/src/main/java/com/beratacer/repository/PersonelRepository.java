package com.beratacer.repository;

import com.beratacer.repository.entity.Personel;
import com.beratacer.utility.StaticValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonelRepository implements ICrud<Personel>{

    @Override
    public void save(Personel personel) {
        StaticValues.personelList.add(personel);
    }

    @Override
    public void update(Long id,Personel personel) {
        for (int i = 0; i< StaticValues.personelList.size(); i++){
            if (StaticValues.personelList.get(i).getId()==id){
                StaticValues.personelList.set(i,personel);
            }
        }
    }

    @Override
    public List<Personel> findAll() {
        return StaticValues.personelList;
    }

    @Override
    public Optional<Personel> findById(Long id) {
        return StaticValues.personelList.stream()
                .filter(x-> x.getId()==id).findFirst();
    }
    public Optional<Personel> findByTcNo(String tcNo){
        return  StaticValues.personelList.stream()
                .filter(x-> x.getTcNo().equals(tcNo)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i< StaticValues.personelList.size(); i++){
            if (StaticValues.personelList.get(i).getId()==id){
                StaticValues.personelList.remove(i);
            }
        }
    }
}
