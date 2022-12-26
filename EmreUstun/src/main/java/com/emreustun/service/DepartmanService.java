package com.emreustun.service;

import com.emreustun.entity.Departman;
import com.emreustun.repository.DepartmanRepository;

import java.util.List;
import java.util.Set;

public class DepartmanService {
    DepartmanRepository departmanRepository;

    public DepartmanService(){
        this.departmanRepository = new DepartmanRepository();
    }
    public void save(Departman departman){
        departmanRepository.save(departman);
    }
    public List<Departman> findAll() {
        return departmanRepository.findAll();
    }
}
