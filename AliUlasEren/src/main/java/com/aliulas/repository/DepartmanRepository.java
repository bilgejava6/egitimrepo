package com.aliulas.repository;

import java.util.HashMap;
import com.aliulas.repository.entity.Departman;

import java.util.List;

import static com.aliulas.utility.StaticValues.departmanListesi;

public class DepartmanRepository implements ICrudD<Departman> {



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
