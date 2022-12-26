package com.emreustun.service;

import com.emreustun.entity.MuhasebePersoneli;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class MuhasebePersoneliService extends PersonelService{
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(MuhasebePersoneli muhasebePersoneli) {
        personelRepository.save(muhasebePersoneli);
    }
    public void update(MuhasebePersoneli muhasebePersoneli) {
        personelRepository.update(muhasebePersoneli);
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
