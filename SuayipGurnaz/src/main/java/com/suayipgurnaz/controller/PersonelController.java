package com.suayipgurnaz.controller;

import com.suayipgurnaz.repository.entity.*;
import com.suayipgurnaz.service.PersonelService;
import static com.suayipgurnaz.utility.PtsUtility.*;

import java.util.List;
import java.util.Scanner;

public class PersonelController{
    private static Scanner sc;
    private final PersonelService personelService;

    public PersonelController() {
        personelService = new PersonelService();
    }

    public void save() {
        System.out.println("***** PERSONEL EKLEME *****");
        System.out.println();
        String ad = stringDegerAlma("Lütfen personel adını giriniz...: ");
        String iseBaslamaTarihi = stringDegerAlma("Lütfen işe başlama tarihini giriniz...: ");
        String departmanAdi = stringDegerAlma("Lütfen departman adını giriniz...: ");
        Personel personel=new Personel();

        switch (departmanAdi){
            case "BURO_PERSONELI": {
                 personel = new BuroPersoneli(ad, iseBaslamaTarihi);
                break;
            }
            case "GENEL_MUDUR":{
                 personel=new GenelMudur(ad, iseBaslamaTarihi);
                break;
            }
            case "HIZMETLI": {
                 personel=new Hizmetli(ad, iseBaslamaTarihi);
            }
            case "IK_PERSONELI": {
                 personel=new IKPersoneli(ad, iseBaslamaTarihi);
            }
            case "MUDUR": {
                 personel=new Mudur(ad, iseBaslamaTarihi);
            }
            case "MUHASEBE_PERSONELI":{
                 personel=new MuhasebePersoneli(ad, iseBaslamaTarihi);
            }
            case "TEKNIK_PERSONEL":{
                 personel=new TeknikPersonel(ad, iseBaslamaTarihi);
            }
        }
        personelService.save(personel);
        }// save sonu

    public void update() {
        System.out.println("***** PERSONEL BİLGİSİ GÜNCELLEME *****");
        System.out.println();
        long id = intDegerAlma("Güncellenecek personelin id'sini giriniz...: ");
        Personel personel = null;
        boolean control=true;
        for(int i=0; i<personelList.size(); i++){
            if(personelList.get(i).getId()==id) {
                personel=personelList.get(i);
                control=false;
                break;
            }
        }
        if(control){
            System.out.println("Güncellenmek istenen personel id'si kayıtlı değil.");
        }else {
            personel.setAd(stringDegerAlma("Lütfen personelin güncel adını giriniz...: "));
            personel.setIseBaslamaTarihi(stringDegerAlma("Lütfen güncel işe başlama tarihini giriniz...: "));
            personel.setDepartman(stringDegerAlma("Lütfen personelin güncel departmanını giriniz...: "));
            personel.setMaas(doubleDegerAlma("Lütfen personelin güncel maaşını giriniz...: "));
        }
        personelService.update(personel);
    }

    public void delete() {
        System.out.println("***** PERSONEL SİLME *****");
        System.out.println();
        long id=intDegerAlma("Silinecek personelin id numarasını giriniz:");
        personelService.delete(id);
    }

    public void findAll() {
        System.out.println("***** PERSONEL LİSTESİ *****");
        System.out.println();
       for (Personel personel: personelService.findAll()) {
                System.out.println("Personel adı...: "+ personel.getAd());
                System.out.println("Personel departmanı...: "+ personel.getDepartman());
                System.out.println("Personel maaşı...: "+ personel.getMaas());
       }
    }

    public Personel findById() {
        System.out.println("***** ID'YE GÖRE PERSONEL BULMA *****");
        System.out.println();
        long id=intDegerAlma("Personelin id numarasını giriniz:");
        return personelService.findById(id);
    }
}
