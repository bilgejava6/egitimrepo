package com.volkangenel.odev.controller;

import com.volkangenel.odev.repository.entity.Departman;
import com.volkangenel.odev.service.DepartmanService;


import java.util.Scanner;

public class DepartmanController {
DepartmanService departmanService = new DepartmanService();
Scanner sc = new Scanner(System.in);

    public void save() {
        System.out.println("Lütfen Departman Adı Giriniz");
        String departmanAdi = sc.nextLine();
        Departman departman = new Departman(departmanAdi);
        departmanService.save(departman);
    }

    public void findAll() {
        System.out.println(departmanService.findAll());
    }
}
