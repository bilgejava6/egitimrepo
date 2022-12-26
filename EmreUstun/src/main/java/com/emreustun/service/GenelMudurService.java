package com.emreustun.service;

import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class GenelMudurService {
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(GenelMudur genelMudur) {
        personelRepository.save(genelMudur);
    }
    public void update(GenelMudur genelMudur) {
        personelRepository.update(genelMudur);
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
