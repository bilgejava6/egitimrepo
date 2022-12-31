package com.beratacer.controller;

import com.beratacer.repository.entity.Departman;
import com.beratacer.service.DepartmanService;

import java.util.Optional;

import static com.beratacer.utility.StaticValues.*;
import static java.lang.Long.parseLong;

public class DepartmanController {
    private final DepartmanService departmanService;

    public DepartmanController() {
        this.departmanService=new DepartmanService();
    }
    public void save(){
        String departmanAdi=stringScanner("Departman adi giriniz : ");
        if (!departmanAdi.isBlank()){
            departmanService.save(new Departman(departmanAdi));
        }else{
            System.out.println("Departman adi bos birakilamaz..");
        }

    }
    public void update(){
        departmanService.update(parseLong(stringScanner("Departman id giriniz : "))
                ,new Departman(stringScanner("Departman adi giriniz : ")));
    }

    public void findAll(){

        departmanService.findAll().forEach(System.out::println);
    }
    public void findById(){
        Long departmanId=longScanner("Departman id giriniz : ");
        Optional<Departman> optionalDepartman=Optional.ofNullable(departmanService.findById(departmanId));
        optionalDepartman.ifPresentOrElse(d->{
            System.out.println(optionalDepartman.get());
        },()->{
            System.out.println("Lutfen gecerli bir id giriniz..");
        });

    }
    public void deleteById(){
        departmanService.deleteById(longScanner("Departman id giriniz : "));
    }
    public void getDepartmanPersonelListesi(){
        departmanService.getDepartmanPersonelListesi().forEach((k,v)-> System.out.println(k+" : "+v));
    }
    public void getEnCokPersonelliDepartman(){
        System.out.println(departmanService.getEnCokPersonelliDepartman());
    }
    public void getDepartmanlaraGoreMaasOrtalamasi(){
        departmanService.getDepartmanlaraGoreMaasOrtalamasi().forEach((k,v)-> System.out.println(k+" : "+v));
    }
}
