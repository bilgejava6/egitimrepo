package com.yavuzavci.controller;

import static com.yavuzavci.entity.ECinsiyet.*;
import static com.yavuzavci.utility.PersonelUtility.*;

import com.yavuzavci.entity.*;
import com.yavuzavci.service.PersonelService;

import java.util.List;

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
        Personel personel;
        switch (yeniPersonelTuruSec()){
            case 1: {
                personel = new BuroPersoneli(adSoyad, cinsiyet, yas, telefon, departman);
                personelService.save(personel);
                break;
            }
            case 2: {
                boolean odemeyeYetkiliMi = odemeYetkisiAl();
                boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                boolean istenCikarabilirMi = istenCikarmaYetkisiAl();
                personel = new GenelMudur(adSoyad,cinsiyet,yas,telefon,departman,
                        odemeyeYetkiliMi,maasTanimlayabilirMi,istenCikarabilirMi);
                personelService.save(personel);
                break;
            }
            case 3:{
                Integer vardiyaSuresi = vardiyaSuresiTanimla();
                personel = new Hizmetli(adSoyad,cinsiyet,yas,telefon,departman,vardiyaSuresi);
                personelService.save(personel);
                break;
            }
            case 4:{
                boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                personel = new InsanKaynaklariPersoneli(adSoyad,cinsiyet,yas,
                        telefon,departman,maasTanimlayabilirMi);
                personelService.save(personel);
                break;
            }
            case 5:{
                boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                boolean istenCikarabilirMi = istenCikarmaYetkisiAl();
                personel = new Mudur(adSoyad,cinsiyet,yas,telefon,
                        departman,maasTanimlayabilirMi,istenCikarabilirMi);
                personelService.save(personel);
                break;
            }
            case 6:{
                boolean odemeyeYetkiliMi = odemeYetkisiAl();
                boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                personel = new MuhasebePersoneli(adSoyad,cinsiyet,yas,telefon,departman,
                        odemeyeYetkiliMi,maasTanimlayabilirMi);
                personelService.save(personel);
                break;
            }
            case 7:{
                Integer vardiyaSuresi = vardiyaSuresiTanimla();
                String teknikAlan = teknikAlanBilgisiAl();
                personel = new TeknikPersonel(adSoyad,cinsiyet,yas,telefon,departman,
                        vardiyaSuresi,teknikAlan);
                personelService.save(personel);
                break;
            }
            default:{
                System.out.println("HATA: Yanlış personel türü seçtiniz.");
                System.out.println("İşlem başarısız.");
                break;
            }
        }
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
