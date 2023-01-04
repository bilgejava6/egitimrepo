package com.suayipgurnaz.service;

import com.suayipgurnaz.repository.ICrud;
import com.suayipgurnaz.repository.PersonelRepository;
import com.suayipgurnaz.repository.entity.Departman;
import com.suayipgurnaz.repository.entity.Personel;

import java.util.List;

public class PersonelService implements ICrud <Personel> {
    PersonelRepository repository;

    public PersonelService() {
        repository = new PersonelRepository();
    }

    @Override
    public void save(Personel personel) {
        if(personel.getAd().isEmpty())
            System.out.println("Eksik bilgi girişi, geçerli bir ad giriniz");
        else {
            repository.save(personel);
        }
    }

    @Override
    public void update(Personel personel) {
        repository.update(personel);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Personel> findAll() {
        return repository.findAll();
    }

    @Override
    public Personel findById(Long id) {
        return repository.findById(id);
    }
}
