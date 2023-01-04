package com.yavuzavci.repository;

import com.yavuzavci.entity.Departman;

import java.util.List;

import static com.yavuzavci.utility.StaticValues.DEPARTMAN_LISTESI;

/**
 * Departman verilerinin sisteme işlendiği katman.
 */
public class DepartmanRepository implements ICrud<Departman> {


    public DepartmanRepository() {

    }

    @Override
    public void save(Departman departman) {
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
    }

    @Override
    public void update(Departman departman) {
        if(DEPARTMAN_LISTESI.containsKey(departman.getId())){
            DEPARTMAN_LISTESI.replace(departman.getId(), departman);
        }
    }

    @Override
    public void delete(Long id) {
        DEPARTMAN_LISTESI.remove(id);
    }

    @Override
    public List<Departman> findAll() {
        return DEPARTMAN_LISTESI.values().stream().toList();
    }

    @Override
    public Departman findById(Long id) {
        return DEPARTMAN_LISTESI.get(id);
    }
}
