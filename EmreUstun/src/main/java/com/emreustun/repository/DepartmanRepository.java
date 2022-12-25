package com.emreustun.repository;

import com.emreustun.entity.Departman;
import com.emreustun.utility.StaticValues;

import java.util.Set;

public class DepartmanRepository implements ICrudDepartman<Departman> {

    @Override
    public void save(Departman departman) {
        StaticValues.departmanListesi.add(departman);
    }

    @Override
    public Set<Departman> findAll() {
        return StaticValues.departmanListesi;
    }
}
