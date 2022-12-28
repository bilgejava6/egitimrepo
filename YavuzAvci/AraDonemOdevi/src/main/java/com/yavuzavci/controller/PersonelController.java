package com.yavuzavci.controller;

import static com.yavuzavci.entity.ECinsiyet.*;

import com.yavuzavci.entity.BuroPersoneli;
import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.Personel;
import com.yavuzavci.service.PersonelService;

import java.util.List;

public class PersonelController {
    private final PersonelService personelService;

    public PersonelController(){
        personelService = new PersonelService();
    }

    public void save(){
        Personel personel = new BuroPersoneli("", DIGER,0,"",new Departman(""));
        personelService.save(personel);
    }
    public void update(){
        Personel personel = new BuroPersoneli("", DIGER,0,"",new Departman(""));
        personelService.update(personel);
    }
    public void delete() {
        Long id = 0L;
        personelService.delete(id);
    }
    public Personel findById(Long id){
        return personelService.findById(id);
    }
    public List<Personel> findAll() {
        return personelService.findAll();
    }
}
