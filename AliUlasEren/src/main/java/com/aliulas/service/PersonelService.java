package com.aliulas.service;

import java.util.List;
import java.util.Set;

import com.aliulas.repository.PersonelRepository;
import com.aliulas.repository.entity.Personel;

import java.util.List;

public class PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelService() {
        super();
        this.personelRepository = new PersonelRepository();
    }

    public void save(Personel personel) {
        personelRepository.save(personel);
    }

    public void update(Personel personel) {
        personelRepository.update(personel);
    }

    public void delete(Long id) {
        personelRepository.delete(id);
    }

    public Personel findById(Long id) {
        return personelRepository.findById(id);
    }

    public List<Personel> findAll() {
        return personelRepository.findAll();
    }
}
