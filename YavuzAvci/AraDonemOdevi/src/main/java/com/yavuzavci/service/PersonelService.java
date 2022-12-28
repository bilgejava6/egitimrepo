package com.yavuzavci.service;

import com.yavuzavci.entity.Personel;
import com.yavuzavci.repository.PersonelRepository;

import java.util.List;
import java.util.Objects;

public class PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelService() {
        this.personelRepository = new PersonelRepository();
    }
    public void save(Personel personel){
        if(personel.getAdSoyad().isEmpty())
            System.out.println("HATA: Personelin ad-soyad bilgisi boş bırakılamaz.");
        else if(Objects.isNull(personel.getCinsiyet()))
            System.out.println("HATA: Personelin cinsiyet bilgisi boş bırakılamaz.");
        else if(Objects.isNull(personel.getYas()))
            System.out.println("HATA: Personelin yaşı boş bırakılamaz.");
        else if(personel.getYas() < 18)
            System.out.println("HATA: Personelin yaşı on sekizden küçük olamaz.");
        else if(Objects.isNull(personel.getDepartman()))
            System.out.println("HATA: Personelin ad-soyad bilgisi boş bırakılamaz.");
        else
            personelRepository.save(personel);
    }
    public void update(Personel personel){
        personelRepository.update(personel);
    }
    public void delete(Long id) {
        if(Objects.isNull(personelRepository.findById(id)))
            System.out.println("HATA: Silmek istediğiniz personel sistemde kayıtlı değildir.");
        else
            personelRepository.delete(id);
    }
    public Personel findById(Long id){
        return personelRepository.findById(id);
    }
    public List<Personel> findAll() {
        return personelRepository.findAll();
    }
}
