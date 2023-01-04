package com.suayipgurnaz.controller;

import com.suayipgurnaz.repository.entity.*;
import com.suayipgurnaz.service.PersonelService;
import com.suayipgurnaz.utility.PtsUtility;
import com.suayipgurnaz.utility.StaticValues;

import static com.suayipgurnaz.utility.PtsUtility.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PersonelController{
    private final PersonelService personelService;

    public PersonelController() {
        personelService = new PersonelService();
    }

    public void save() {
        System.out.println("***** PERSONEL EKLEME *****");
        System.out.println();
        String ad = stringDegerAlma("Lütfen personel adını giriniz...: ");
        String iseBaslamaTarihi = stringDegerAlma("Lütfen işe başlama tarihini giriniz...: ");
        
        Personel personel=new Personel();
        boolean control;
        do {
        	control=false;
        	String departmanAdi = stringDegerAlma("Lütfen departman adını giriniz...: ");
        	
            switch (departmanAdi.toUpperCase()){
                case "BURO_PERSONELI", "B�RO PERSONEL�", "B�RO","BURO": {
                     personel = new BuroPersoneli(ad, iseBaslamaTarihi);
                    break;
                }
                case "GENEL_MUDUR", "GENEL M�D�R","GENEL MUDUR":{
                     personel=new GenelMudur(ad, iseBaslamaTarihi);
                    break;
                }
                case "HIZMETLI","H�ZMETL�": {
                     personel=new Hizmetli(ad, iseBaslamaTarihi);
                     break;
                }
                case "IK_PERSONELI","�K PERSONEL�","�K","IK": {
                     personel=new IKPersoneli(ad, iseBaslamaTarihi);
                     break;
                }
                case "MUDUR","M�D�R": {
                	Set<Departman> mudurSorumlulukList=mudurSorumlulukBelirle();
                     personel=new Mudur(ad, iseBaslamaTarihi, mudurSorumlulukList);
                     break;
                }
                case "MUHASEBE_PERSONELI","MUHASEBE PERSONEL�","MUHASEBE":{
                     personel=new MuhasebePersoneli(ad, iseBaslamaTarihi);
                     break;
                }
                case "TEKNIK_PERSONEL","TEKN�K PERSONEL","TEKN�K":{
                     personel=new TeknikPersonel(ad, iseBaslamaTarihi);
                     break;
                }
                default:{
                	System.out.println("Uygun departman ismi girilmedi...");
                	control=true;
                	break;
                }
             }
        }while(control);
        
        personelService.save(personel);
        
    }// save sonu
    
    private Set<Departman> mudurSorumlulukBelirle() {
    	Set<Departman> mudurSorumlulukList=new LinkedHashSet<>();
    	int secim;
    	do {
    		secim=PtsUtility.intDegerAlma("Bu m�d�re ba�l� departman eklemek i�in 1'e , ��kmak i�in 0'a bas�n�z:");
    		if(secim==1) {
    			String departmanAdi=PtsUtility.stringDegerAlma("Departman ad� giriniz:");
    			boolean eklendiMi=true;
    			for (int i = 0; i < departmanList.size(); i++) {
					if(departmanList.get(i).getAd().equalsIgnoreCase(departmanAdi)) {
						mudurSorumlulukList.add(departmanList.get(i));
						eklendiMi=false;
					}
				}    			 
    			if(eklendiMi){
    				System.out.println("Belirtilen departman kay�tl� de�il...");
    			}	
    			
    		}else {
    			secim=0;
    		}
    	}while(secim!=0);
    	
		return mudurSorumlulukList;
	}

	public void baslangicVerisiOlustur() {
    	personelService.save(new MuhasebePersoneli("Ali", "2009.05.22"));
    	personelService.save(new Hizmetli("Mehmet", "2018.05.27"));
    	personelService.save(new TeknikPersonel("Ahmet", "2018.05.27"));
    	personelService.save(new Hizmetli("Kaan", "2018.05.27"));
    	personelService.save(new IKPersoneli("Ayse", "2019.03.12"));
    	personelService.save(new MuhasebePersoneli("Fatma", "2019.03.12"));
    	personelService.save(new TeknikPersonel("Oya", "2013.03.22"));
    }

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
            personelService.update(personel);
        }
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
                System.out.println("Personel departmanı...: "+ personel.getDepartman().getAd());
                System.out.println("Personel ise baslama tarihi...: "+ personel.getIseBaslamaTarihi());
                System.out.println("Personel �ID...: "+ personel.getId());
       }
    }

    public Personel findById() {
        System.out.println("***** ID'YE GÖRE PERSONEL BULMA *****");
        System.out.println();
        long id=intDegerAlma("Personelin id numarasını giriniz:");
        return personelService.findById(id);
    }
}
