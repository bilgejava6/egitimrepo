package com.volkangenel.odev.service;

import com.volkangenel.odev.repository.AbstractDepartman;
import com.volkangenel.odev.repository.DepartmanRepository;
import com.volkangenel.odev.repository.entity.Departman;


import java.util.List;

public class DepartmanService extends AbstractDepartman<Departman> {
DepartmanRepository departmanRepository = new DepartmanRepository();

    @Override
    public void save(Departman t) {
    departmanRepository.save(t);
    }

    @Override
    public List findAll() {

        return departmanRepository.findAll();
    }
}
