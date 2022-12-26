package com.emreustun.service;

import com.emreustun.entity.Hizmetli;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class HizmetliService {
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(Hizmetli hizmetli) {
        personelRepository.save(hizmetli);
    }
    public void update(Hizmetli hizmetli) {
        personelRepository.update(hizmetli);
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
