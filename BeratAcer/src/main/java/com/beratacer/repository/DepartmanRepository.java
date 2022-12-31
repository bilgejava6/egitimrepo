package com.beratacer.repository;

import com.beratacer.repository.entity.Departman;
import com.beratacer.utility.StaticValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmanRepository implements ICrud<Departman>{

    @Override
    public void save(Departman departman) {
        StaticValues.departmanList.add(departman);
    }

    @Override
    public void update(Long id, Departman departman) {
        for (int i=0; i<StaticValues.departmanList.size();i++){
            if (StaticValues.departmanList.get(i).getId()==id){
                StaticValues.departmanList.set(i,departman);
            }
        }
    }

    @Override
    public List<Departman> findAll() {
        return StaticValues.departmanList;
    }

    @Override
    public Optional<Departman> findById(Long id) {
        return StaticValues.departmanList.stream()
                .filter(x-> x.getId()==id).findFirst();
    }
    public Optional<Departman> findByName(String name){
        return StaticValues.departmanList.stream()
                .filter(x-> x.getAd().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        for (int i=0;i<StaticValues.departmanList.size();i++){
            if (StaticValues.departmanList.get(i).getId()==id){
                StaticValues.departmanList.remove(i);
            }
        }
    }
}
