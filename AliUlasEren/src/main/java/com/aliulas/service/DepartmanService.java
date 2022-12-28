package com.aliulas.service;

import com.aliulas.repository.DepartmanRepository;
import com.aliulas.repository.entity.Departman;

import java.util.List;

public class DepartmanService {
    private final DepartmanRepository departmanRepository;

    public DepartmanService() {
        this.departmanRepository = new DepartmanRepository();
    }
    public void save(Departman departman){
        departmanRepository.save(departman);
    }
    public void update(Departman departman){
        departmanRepository.update(departman);
    }
    public void delete(Long id) {
        departmanRepository.delete(id);
    }
    public Departman findById(Long id){
        return departmanRepository.findById(id);
    }
    public List<Departman> findAll() {
        return departmanRepository.findAll();
    }
}
