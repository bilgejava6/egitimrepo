package com.yavuzavci.repository;

import com.yavuzavci.entity.Departman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DepartmanRepository implements ICrud<Departman> {
    private Map<Long,Departman> departmanListesi;


    public DepartmanRepository() {
        departmanListesi = new HashMap<>();
    }

    @Override
    public void save(Departman departman) {
        departmanListesi.put(departman.getId(),departman);
    }

    @Override
    public void update(Departman departman) {
        if(departmanListesi.containsKey(departman.getId())){
            departmanListesi.replace(departman.getId(), departman);
        }
    }

    @Override
    public void delete(Long id) {
        departmanListesi.remove(id);
    }

    @Override
    public List<Departman> findAll() {
        return departmanListesi.values().stream().toList();
    }

    @Override
    public Departman findById(Long id) {
        return departmanListesi.get(id);
    }
}
