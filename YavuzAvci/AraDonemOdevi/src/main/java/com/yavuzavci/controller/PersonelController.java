package com.yavuzavci.controller;

import static com.yavuzavci.entity.ECinsiyet.*;
import static com.yavuzavci.utility.PersonelUtility.*;

import com.yavuzavci.entity.*;
import com.yavuzavci.service.PersonelService;

import java.util.List;
import java.util.Objects;

public class PersonelController {
    private final PersonelService personelService;

    public PersonelController(){
        personelService = new PersonelService();
    }

    public void save(){
        // her personel için geçerli
        String adSoyad = adSoyadAl();
        ECinsiyet cinsiyet = cinsiyetAl();
        Integer yas = yasAl();
        String telefon = telefonAl();
        Departman departman = departmanAl();
        // personel türüne göre değişen işlemler
        Personel personel = null;
        switch (yeniPersonelTuruSec()){
            case 1:
                personel = new BuroPersoneli(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            case 2:
                personel = new GenelMudur(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            case 3:
                personel = new Hizmetli(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            case 4:
                personel = new InsanKaynaklariPersoneli(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            case 5:
                personel = new Mudur(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            case 6:
                personel = new MuhasebePersoneli(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            case 7:
                personel = new TeknikPersonel(adSoyad,cinsiyet,yas,telefon,departman);
                break;
            default:
                System.out.println("HATA: Yanlış personel türü seçtiniz.");
                break;
        }
        if(Objects.isNull(personel))
            System.out.println("İşlem başarısız.");
        else
            personelService.save(personel);
    }
    public void update(){
        Personel personel = new BuroPersoneli("", DIGER,0,"",new Departman(""));
        personelService.update(personel);
    }
    public void delete() {
        Long id = silinecekPersonelIdAl();
        personelService.delete(id);
    }
    public Personel findById(Long id){
        return personelService.findById(id);
    }
    public List<Personel> findAll() {
        return personelService.findAll();
    }
}
