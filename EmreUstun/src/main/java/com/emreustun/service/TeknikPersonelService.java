package com.emreustun.service;

import com.emreustun.entity.Personel;
import com.emreustun.entity.TeknikPersonel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class TeknikPersonelService extends PersonelService {
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(TeknikPersonel teknikPersonel) {
        personelRepository.save(teknikPersonel);
    }
    public void update(TeknikPersonel teknikPersonel) {
        personelRepository.update(teknikPersonel);
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
