package com.volkangenel.odev.service;

import com.volkangenel.odev.repository.ICrud;
import com.volkangenel.odev.repository.PersonelRepository;
import com.volkangenel.odev.repository.entity.Personel;


import java.util.List;

public class PersonelService implements ICrud<Personel> {
    PersonelRepository personelRepository = new PersonelRepository();
    @Override
    public void save(Personel personel) {
       personelRepository.save(personel);
    }

    @Override
    public void update(Personel personel) {

    }

    @Override
    public List<Personel> findAll() {
        personelRepository.findAll();
        return null;
    }

    @Override
    public Personel findById(Long id) {
        return personelRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    personelRepository.deleteById(id);
    }
}
