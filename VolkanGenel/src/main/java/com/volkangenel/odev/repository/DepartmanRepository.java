package com.volkangenel.odev.repository;

import com.volkangenel.odev.repository.entity.Departman;

import java.util.List;

import static com.volkangenel.odev.repository.entity.utility.StaticValues.*;

public class DepartmanRepository extends AbstractDepartman <Departman>  {

    @Override
    public void save(Departman t) {
    departmanListesi.add(t);
    }

    @Override
    public List findAll() {
        return departmanListesi;
    }
}
