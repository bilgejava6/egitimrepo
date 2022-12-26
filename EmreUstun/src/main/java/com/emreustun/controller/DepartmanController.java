package com.emreustun.controller;

import com.emreustun.entity.Departman;
import com.emreustun.service.DepartmanService;

import java.util.Scanner;

public class DepartmanController {
    DepartmanService departmanService = new DepartmanService();
    Scanner sc = new Scanner(System.in);
    public void save(){
        Departman departman = new Departman();
        System.out.println("Departman adi giriniz");
        departman.setAd(sc.nextLine());
        System.out.println("Vardiya Sayisini giriniz.");
        departman.setVardiyaSayisi(sc.nextInt());
        sc.nextLine();
        departmanService.save(departman);
    }
    public void findAll() {
        for(Departman departman : departmanService.findAll()) {
            System.out.println(departman);
        }
    }
}
