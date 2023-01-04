package com.suayipgurnaz;

import com.suayipgurnaz.controller.DepartmanController;
import com.suayipgurnaz.controller.PersonelController;
import com.suayipgurnaz.repository.entity.Departman;
import com.suayipgurnaz.repository.entity.Mudur;
import com.suayipgurnaz.repository.entity.Personel;
import com.suayipgurnaz.utility.PtsUtility;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PTSManager {
    public PersonelController personelController;
    public DepartmanController departmanController;

    public PTSManager() {
		super();
		personelController=new PersonelController();
		departmanController=new DepartmanController(); 
	}

	public void run(){
		departmanController.baslangicDepartmanlariOlustur();
		personelController.baslangicVerisiOlustur();
        int secim=0;
        int secim2=0;
        do{
            anaMenu();
            secim= PtsUtility.intDegerAlma("Islem Seciniz...: ");
            switch (secim){
                case 1:
                    personelIslemleriMenu();
                    secim2= PtsUtility.intDegerAlma("Islem Seciniz...: ");
                    switch (secim2){
                        case 1:
                            personelController.save();
                            break;
                        case 2:
                            personelController.findAll();
                            break;
                        case 3:
                            personelController.update();
                            break;
                        case 4:
                            departmanController.save();
                            break;
                        case 5:
                            departmanController.findAll();
                            break;
                        default:
                            System.out.println("Uygun değer girmediniz");
                    }
                    break;
                case 2:
                    muhasebeIslemleriMenu();
                    secim2= PtsUtility.intDegerAlma("��lem Seciniz...: ");
                    switch (secim2){
                        case 1:
                            maasPersonelTanimlama();
                            break;
                        case 2:
                            odemeListesi();
                            break;
                        default:
                            System.out.println("Uygun değer girmediniz");
                    }
                    break;
                case 3:
                    raporlamalarMenu();
                    secim2= PtsUtility.intDegerAlma("��lem Seciniz...: ");
                    switch (secim2){
                        case 1:
                            departmanPersonelListesi();
                            break;
                        case 2:
                            enCokPersoneliOlanDepartman();
                            break;
                        case 3:
                            departmanMaasOrtalamalari();
                            break;
                        case 4:
                            mudurSorumlulukListesi2();
                            break;
                        case 5:
                            kayitTarihineGorePersonelListesi();
                            break;
                        case 6:
                            ayniGunIseBaslayanlar();
                            break;
                        default:
                            System.out.println("Uygun deger girmediniz");
                    }
                    break;
                case 0:
                    System.out.println("Cikis yapılıyor...");
                    break;
                default:
                    System.out.println("Uygun bir değer girmediniz...");
                    break;
            }
        }while(secim!=0);
    }

    private void ayniGunIseBaslayanlar() {
        System.out.println("Aynı gün işe başlayanlar...: ");
        List<Personel> sortedPersonelList=sortedPersonelList();
        Set<Integer> ayniGunIndexSet = new LinkedHashSet<>();
        for (int i=0; i<sortedPersonelList.size()-1; i++){
            if(sortedPersonelList.get(i).getIseBaslamaTarihi().equalsIgnoreCase(sortedPersonelList.get(i+1).getIseBaslamaTarihi())){
                ayniGunIndexSet.add(i);
                ayniGunIndexSet.add(i+1);
            }
        }
        List<Integer> ayniGunIndexList = ayniGunIndexSet.stream().toList();
        if(ayniGunIndexList.size()>0){
            for(int i=0; i<ayniGunIndexList.size(); i++){
                System.out.println(sortedPersonelList.get(ayniGunIndexList.get(i)));
            }
        }
    }
    private void kayitTarihineGorePersonelListesi() {
        System.out.println("Kayıt Tarihine Göre Personel Listesi");
        List<Personel> sortedPersonelList=sortedPersonelList();
        for (Personel personel : sortedPersonelList ) {
            System.out.println(personel);
        }
    }
    private List<Personel> sortedPersonelList(){
        return PtsUtility.personelList.stream().sorted(Comparator.comparing(Personel::getIseBaslamaTarihi))
                .collect(Collectors.toList());
    }
    private void mudurSorumlulukListesi() {
        System.out.println("Müdür Sorumluluk Listesi");
        long mudurId=PtsUtility.intDegerAlma("Sorumluluk Listesini Görmek İstediğiniz Müdürün ID'sini giriniz..: ");
        for(int i=0; i<PtsUtility.personelList.size(); i++){
            if(PtsUtility.personelList.get(i).getId()==mudurId &&
                    PtsUtility.personelList.get(i).getClass().getSimpleName().equalsIgnoreCase("mudur")){
                Mudur mudur= (Mudur) PtsUtility.personelList.get(i);
                for(Departman departman : mudur.getSorumluOlduguDepartmanlar()){
                    System.out.println(departman.getAd());
                }
            }
        }
    }
    private void mudurSorumlulukListesi2() {
    	System.out.println("T�m m�d�rler ve sorumlu oldu�u departmanlar");
    	List<Personel> mudurList =  PtsUtility.personelList.stream().filter(x-> x.getDepartman().getAd().equalsIgnoreCase("YONETICI"))
    			.collect(Collectors.toList());
    	
    	for(Personel mudur : mudurList) {
    		Mudur m=(Mudur)mudur;
    		System.out.println(m.getAd()+" isimli mudure bagli departmanlar:");
    		for(Departman departman : m.getSorumluOlduguDepartmanlar()) {
    			System.out.println(departman.getAd());
    		}
    	}
    }
    
    private void departmanMaasOrtalamalari() {
        System.out.println("Departmanlara göre maaş ortalamaları ");
        departmanPersonelMapYap();

        PtsUtility.personelMap.forEach((k,v)->{
            System.out.println(k+"-"+v.stream().collect(Collectors.averagingDouble(z->z.getMaas())));
        });
    }
    private void enCokPersoneliOlanDepartman() {
        int max=-1;
        int index=-1;
        for(int i=0; i<PtsUtility.departmanList.size(); i++){
            if(PtsUtility.departmanList.get(i).getPersonelSayisi()>max) {
                max = PtsUtility.departmanList.get(i).getPersonelSayisi();
                index=i;
            }
        }
        System.out.println("En çok elemanı olan "+PtsUtility.departmanList.get(index).getAd()
        +" departmanının "+PtsUtility.departmanList.get(index).getPersonelSayisi()+" adet personeli vardır...");
    }
    private void departmanPersonelMapYap(){
         PtsUtility.personelMap = PtsUtility.personelList.stream().collect(Collectors.groupingBy(g->g.getDepartman().getAd()));
    }
    private void departmanPersonelListesi() {
        System.out.println("Departmanlara Göre Personel Listesi");
        departmanPersonelMapYap();
        PtsUtility.personelMap.forEach((x,y)->System.out.println(x+"-"+y));
    }
    private void odemeListesi() {
        System.out.println("Ödeme Listesi");
        PtsUtility.personelList.stream().filter(x->{
            if(x.getMaas()>0) {
                return true;
            } else{
            return false;
        }
        }).forEach(System.out::println);
    }

    private void maasPersonelTanimlama() {
        System.out.println("Maaş Personel Tanımlama");
        Personel personel = personelController.findById();
        personel.setMaas(PtsUtility.doubleDegerAlma("Personelin alacağı maaşı giriniz..:"));
    }

    public void anaMenu(){
        System.out.println();
        System.out.println("****** PERSONEL TAKİP SİSTEMİ *******");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1- Personel Islemleri");
        System.out.println("2- Muhasebe Islemleri");
        System.out.println("3- Raporlamalar");
        System.out.println("0- C I K I S");
    }
    public void personelIslemleriMenu(){
        System.out.println("***** Personel Islemleri *****");
        System.out.println("1- Personel Ekleme ");
        System.out.println("2- Personel Listesi ");
        System.out.println("3- Personel Düzenleme ");
        System.out.println("4- Departman Ekleme ");
        System.out.println("5- Departman Listesi ");
    }
    public void muhasebeIslemleriMenu(){
        System.out.println("***** Muhasebe Islemleri *****");
        System.out.println("1- Maaş Personel Tanımlama ");
        System.out.println("2- Ödeme Listesi ");
    }
    public void raporlamalarMenu(){
        System.out.println("***** Raporlamalar *****");
        System.out.println("1- Departman Personel Listesi ");
        System.out.println("2- En Çok Personel Bulunduran Departman ");
        System.out.println("3- Departmanlara Göre Maaş Ortalamaları ");
        System.out.println("4- Mudurlerin Sorumlu Olduğu Departman Listesi ");
        System.out.println("5- Kay�t Tarihine Göre Personellerin Sirali Listesi ");
        System.out.println("6- Aynı Gun İçinde Ise Başlayan Personellerin Listesi ");
    }
}

