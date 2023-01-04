package com.aliakkulah.service;

import java.util.List;
import java.util.Map;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Mudur;
import com.aliakkulah.entity.Personel;
import com.aliakkulah.repository.PersonelRepository;

public class PersonelService {
    private final PersonelRepository pr;

    public PersonelService() {
        super();
        this.pr = new PersonelRepository();
    }
    public void save(Personel personel) {pr.save(personel);}
    public void update(Personel personel) {pr.update(personel);}
    public void delete(Personel personel) {pr.delete(personel);}
    public List<Personel> findAll() {return pr.findAll();}
    public void findById(Long id) {pr.findById(id);}
    public void deleteById(Long id) {pr.deleteById(id);}
    public Map<String,Double> odemeListesi() {return pr.odemeListesi();}
    public void siraliPersonelListesi() {pr.siraliPersonelListesi();}
    public void ayniGunBaslayanlarListesi() {pr.ayniGunBaslayanlarListesi();}
    public void mudureSorumluOlduguDepartmanEkle(Mudur mudur, Departman departman) {pr.mudureSorumluOlduguDepartmanEkle(mudur, departman);}

    public void mudurlerinSorumluOlduguDepartmanlar() {pr.mudurlerinSorumluOlduguDepartmanlar();}
}