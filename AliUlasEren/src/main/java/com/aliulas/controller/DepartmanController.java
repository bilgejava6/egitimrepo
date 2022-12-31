package com.aliulas.controller;

import com.aliulas.repository.entity.Departman;
import com.aliulas.repository.entity.Personel;
import com.aliulas.service.DepartmanService;
import com.aliulas.service.PersonelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmanController {
    private final DepartmanService departmanService;
    Scanner sc = new Scanner(System.in);

    public DepartmanController(){
        departmanService = new DepartmanService();
    }


    public void save(){
        Departman departman = new Departman();
        System.out.println("Departman adi giriniz");
        departman.setAd(sc.nextLine());
        System.out.println("Calisan Sayisini giriniz.");
        departman.setCalisanSayisi(sc.nextInt());
        List<Personel> personelListesi = new ArrayList<>(departman.getCalisanSayisi());
        departman.setPersonelListesi(personelListesi);
        sc.nextLine();//scanner bug
        departmanService.save(departman);
    }
    public void update(Departman departman){
        departmanService.update(departman);
    }
    public void delete(Long id) {
        departmanService.delete(id);
    }
    public Departman findById(Long id){
        return departmanService.findById(id);
    }
    public List<Departman> findAll() {
        return departmanService.findAll();
    }

}
