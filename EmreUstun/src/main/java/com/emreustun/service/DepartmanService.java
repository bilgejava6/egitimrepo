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
    public void save(String ad, int calisanSayisi){
        Departman departman = new Departman(ad);
        departmanRepository.save(departman);
    }
    public Set<Departman> findAll() {
        return departmanRepository.findAll();
    }
}
