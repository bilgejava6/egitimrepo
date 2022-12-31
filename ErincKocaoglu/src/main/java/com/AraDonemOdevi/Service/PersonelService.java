package com.AraDonemOdevi.Service;

import com.AraDonemOdevi.Entity.Personel;
import com.AraDonemOdevi.Reposiyory.PersonelRepository;

import java.util.Map;

public class PersonelService {

    private PersonelRepository personelRepository;


    public PersonelService() {
        super();
        this.personelRepository = new PersonelRepository();
    }

    public void save(Personel personel) {
        personelRepository.save(personel);
    }

    public void save(String PersAd, String perSoyad, String departman) {
        Personel personel = new Personel();
        personel.setAd(PersAd);
        personel.setSoyad(perSoyad);
        personel.setDepartman(departman);
        personel.setMaas(0);

        personelRepository.save(personel);
    }

    public void update(Personel personel, Personel newPersonel){
        personelRepository.update(personel, newPersonel);
    }

    public void delete(Personel ad) {
        personelRepository.delete(ad);
    }

    public Map<Long,Personel> findAll() {
        return personelRepository.findAll();
    }

    public Personel findById(Long id) {
        return personelRepository.findById(id);
    }

    public void deleteById(Long id){
        personelRepository.deleteById(id);
    }


}
