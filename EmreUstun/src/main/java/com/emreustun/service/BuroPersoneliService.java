package com.emreustun.service;

import com.emreustun.entity.BuroPersoneli;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;

import java.util.List;

public class BuroPersoneliService {
    private final PersonelRepository personelRepository = new PersonelRepository();

    public void save(BuroPersoneli buroPersoneli) {
        personelRepository.save(buroPersoneli);
    }
    public void update(BuroPersoneli buroPersoneli) {
        personelRepository.update(buroPersoneli);
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
