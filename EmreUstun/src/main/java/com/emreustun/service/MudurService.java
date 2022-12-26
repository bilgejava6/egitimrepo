package com.emreustun.service;

import com.emreustun.entity.Mudur;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class MudurService {
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(Mudur mudur) {
        personelRepository.save(mudur);
    }
    public void update(Mudur mudur) {
        personelRepository.update(mudur);
    }
    public void delete(Long id){
        personelRepository.delete(id);
    }
    public Personel findById(Long id){
        return personelRepository.findById(id);
    }
    public List<Personel> findAll(){
        return personelRepository.findAll();
    }
}
