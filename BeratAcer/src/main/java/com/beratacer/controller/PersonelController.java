package com.beratacer.controller;

import com.beratacer.repository.entity.*;
import com.beratacer.service.DepartmanService;
import com.beratacer.service.PersonelService;
import static com.beratacer.utility.PersonelValues.*;
import static com.beratacer.utility.MenuValues.*;
import java.util.List;
import java.util.Optional;

import static com.beratacer.utility.StaticValues.*;
import static java.lang.Long.parseLong;


public class PersonelController {
    private final PersonelService personelService;
    private final DepartmanService departmanService;


    public PersonelController() {
        this.personelService=new PersonelService();
        this.departmanService=new DepartmanService();

    }
    public void save(){

        switch (pozisyonlar()){
            case 1 :
                GenelMudur genelMudur=genelMudur(departmanService);
                if (isBlank(genelMudur)==true){
                    personelService.save(genelMudur);
                }else{
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            case 2 :
                Mudur mudur=mudur(departmanService);
                if (isBlank(mudur)==true){
                    personelService.save(mudur(departmanService));
                }else{
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            case 3 :
                InsanKaynaklariPersoneli insanKaynaklariPersoneli=insanKaynaklari(departmanService);
                if (isBlank(insanKaynaklariPersoneli)==true){
                    personelService.save(insanKaynaklariPersoneli);
                }else{
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            case 4 :
                BuroPersoneli buroPersoneli=buroPersoneli(departmanService);
                if (isBlank(buroPersoneli)==true){
                    personelService.save(buroPersoneli);
                }else{
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            case 5 :
                Hizmetli hizmetli=hizmetli(departmanService);
                if (isBlank(hizmetli)==true){
                    personelService.save(hizmetli);
                }else {
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            case 6 :
                MuhasebePersoneli muhasebePersoneli=muhasebe(departmanService);
                if (isBlank(muhasebePersoneli)==true){
                    personelService.save(muhasebePersoneli);
                }else{
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            case 7 :
                TeknikPersonel teknikPersonel=teknikPersonel(departmanService);
                if (isBlank(teknikPersonel)==true){
                    personelService.save(teknikPersonel);
                }else{
                    System.out.println("Lutfen bos alan birakmayiniz..");
                }
                break;
            default:
                System.out.println("Lutfen gecerli bir pozisyon seciniz..");
        }

    }
    public void update(){
        switch (pozisyonlar()){
            case 1 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),genelMudur(departmanService)); break;
            case 2 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),mudur(departmanService)); break;
            case 3 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),insanKaynaklari(departmanService)); break;
            case 4 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),buroPersoneli(departmanService)); break;
            case 5 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),hizmetli(departmanService)); break;
            case 6 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),muhasebe(departmanService)); break;
            case 7 :
                personelService.update(parseLong(stringScanner("Personel id giriniz : ")),teknikPersonel(departmanService)); break;
            default :
                System.out.println("Lutfen gecerli bir pozisyon seciniz..");

        }

    }
    public void findAll(){
        personelService.findAll().forEach(System.out::println);
    }
    public void findById(){
        Long personelId=longScanner("Lutfen id giriniz : ");
        Optional<Personel> optionalPersonel=Optional.ofNullable(personelService.findById(personelId));
        optionalPersonel.ifPresentOrElse(p->{
            System.out.println(optionalPersonel.get());
        },()->{
            System.out.println("Lutfen gecerli bir id giriniz..");
        });
    }
    public void deleteById(){
        personelService.deleteById(longScanner("Lutfen id giriniz : "));
    }
    public void maasPersonelTanimlama(){
        personelService.maasPersonelTanimlama(stringScanner("Personel tcNo giriniz : "),doubleScanner("Maas giriniz : "));
    }
    public void getOdemeListesi(){
        personelService.getOdemeListesi().forEach((k,v)-> System.out.println(k+" : "+v));
    }
    public void getKayitTarihlerineGorePersoneller(){
        personelService.getKayitTarihlerineGorePersoneller().forEach((k,v)-> System.out.println(k+" : "+v));
    }
    public void getAyniTarihliPersoneller(){
        personelService.getAyniTarihliPersoneller();
    }
    public void getSorumluOlunanDepartmanlar(){
        personelService.getSorumluOlunanDepartmanlar(parseLong(stringScanner("Mudur id giriniz : "))).forEach(System.out::println);
    }
}
