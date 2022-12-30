package com.aliakkulah.service;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Personel;
import com.aliakkulah.repository.DepartmanRepository;

import java.util.List;
import java.util.Map;

public class DepartmanService {
    private final DepartmanRepository dr;

    public DepartmanService() {dr = new DepartmanRepository();}

    public void save(Departman departman) {
        dr.save(departman);
    }

    public List<Departman> findAll() {
        return dr.findAll();
    }

    public List<Personel> departmanPersonelListesi(Departman departman) {
        return dr.departmanPersonelListesi(departman);
    }

    public List<Departman> enCokPersonelliDepartman() {
        return dr.enCokPersonelliDepartman();
    }
}