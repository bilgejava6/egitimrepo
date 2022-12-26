package com.emreustun.service;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class PersonelService {
    private final PersonelRepository personelRepository;
    public PersonelService() {
        this.personelRepository = new PersonelRepository();
    }
    public void save(Personel personel){
        personelRepository.save(personel);
    }
    public void update(Personel personel){
        personelRepository.update(personel);
    }
    public void delete(Long id) {
        personelRepository.delete(id);
    }
    public Personel findById(Long id){
        return personelRepository.findById(id);
    }
    public List<Personel> findAll() {
        return personelRepository.findAll();
    }
}
