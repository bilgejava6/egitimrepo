package com.aliakkulah.service;

import java.util.List;
import java.util.Map;

import com.aliakkulah.entity.Personel;
import com.aliakkulah.repository.PersonelRepository;

public class PersonelService {
    private final PersonelRepository pr;

    public PersonelService() {
        super();
        this.pr = new PersonelRepository();
    }

    public void save(Personel personel) {
        pr.save(personel);
    }

    public void update(Personel personel) {

    }
    public void delete(Personel personel) {

    }

    public List<Personel> findAll() {
        return pr.findAll();
    }

    public Personel findById(Long id) {
        return null;
    }

    public void deleteById(Long id) {

    }

    public Map<String,Double> odemeListesi() {
        return pr.odemeListesi();
    }
}