package com.emreustun.service;

import com.emreustun.entity.InsanKaynaklariPersoneli;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class InsanKaynaklariPersoneliService  {
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(InsanKaynaklariPersoneli insanKaynaklariPersoneli) {
        personelRepository.save(insanKaynaklariPersoneli);
    }
    public void update(InsanKaynaklariPersoneli insanKaynaklariPersoneli) {
        personelRepository.update(insanKaynaklariPersoneli);
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
