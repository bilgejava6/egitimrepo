package com.yavuzavci.repository;

import com.yavuzavci.entity.Departman;

import java.util.List;

import static com.yavuzavci.utility.StaticValues.departmanListesi;

/**
 * Departman verilerinin sisteme işlendiği katman.
 */
public class DepartmanRepository implements ICrud<Departman> {


    public DepartmanRepository() {

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
