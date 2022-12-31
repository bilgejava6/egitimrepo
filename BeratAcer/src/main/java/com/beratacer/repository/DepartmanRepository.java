package com.beratacer.repository;

import com.beratacer.repository.entity.Departman;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmanRepository implements ICrud<Departman>{
    private List<Departman> departmanListesi;

    public DepartmanRepository() {
        this.departmanListesi = new ArrayList<>();
    }

    @Override
    public void save(Departman departman) {
        departmanListesi.add(departman);
    }

    @Override
    public void update(Long id, Departman departman) {
        for (int i=0; i<departmanListesi.size();i++){
            if (departmanListesi.get(i).getId()==id){
                departmanListesi.set(i,departman);
            }
        }
    }

    @Override
    public List<Departman> findAll() {
        return departmanListesi;
    }

    @Override
    public Optional<Departman> findById(Long id) {
        return departmanListesi.stream()
                .filter(x-> x.getId()==id).findFirst();
    }
    public Optional<Departman> findByName(String name){
        return departmanListesi.stream()
                .filter(x-> x.getAd().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        for (int i=0;i<departmanListesi.size();i++){
            if (departmanListesi.get(i).getId()==id){
                departmanListesi.remove(i);
            }
        }
    }
}
