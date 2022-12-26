package com.yavuzavci.controller;

import com.yavuzavci.entity.Personel;
import com.yavuzavci.service.PersonelService;

import java.util.List;

public class PersonelController {
    private final PersonelService personelService;

    public PersonelController(){
        personelService = new PersonelService();
    }

    public void save(Personel personel){
        personelService.save(personel);
    }
    public void update(Personel personel){
        personelService.update(personel);
    }
    public void delete(Long id) {
        personelService.delete(id);
    }
    public Personel findById(Long id){
        return personelService.findById(id);
    }
    public List<Personel> findAll() {
        return personelService.findAll();
    }
}
