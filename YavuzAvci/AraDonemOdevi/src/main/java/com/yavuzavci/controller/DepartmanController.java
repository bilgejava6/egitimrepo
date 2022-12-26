package com.yavuzavci.controller;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.service.DepartmanService;

import java.util.List;

public class DepartmanController {
    private final DepartmanService departmanService;

    public DepartmanController(){
        departmanService = new DepartmanService();
    }

    public void save(Departman departman){
        departmanService.save(departman);
    }
    public void update(Departman departman){
        departmanService.update(departman);
    }
    public void delete(Long id) {
        departmanService.delete(id);
    }
    public Departman findById(Long id){
        return departmanService.findById(id);
    }
    public List<Departman> findAll() {
        return departmanService.findAll();
    }

}