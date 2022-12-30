package com.emreustun.service;

import com.emreustun.entity.Departman;
import com.emreustun.entity.ECinsiyet;
import com.emreustun.entity.Personel;
import com.emreustun.repository.PersonelRepository;
import com.emreustun.utility.StaticValues;

import java.util.List;

public class PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelService() {
        this.personelRepository = new PersonelRepository();
    }

    public void save(Personel personel) {
        if (personel.getYas() < 15 || personel.getYas() > 80) {
            System.err.println("Personelin yaşı 80'den büyük veya 15'den küçük olamaz..");
        }else
            personelRepository.save(personel);
    }

    public void update(Personel personel) {
        if (personel.getYas() < 15 || personel.getYas() > 80) {
            System.err.println("Personelin yaşı 80'den büyük veya 15'den küçük olamaz..");
        }else
            personelRepository.update(personel);
    }

    public void delete(Long id) {
        personelRepository.delete(id);
    }

    public Personel findById(Long id) {
        return personelRepository.findById(id);
    }

    public List<Personel> findAll() {
        if (StaticValues.personelListesi.isEmpty()) {
            System.err.println("Personel listesi boş");
            return null;
        } else
            return personelRepository.findAll();
    }
}
