package com.aliakkulah.controller;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.service.DepartmanService;
import java.util.Scanner;

public class DepartmanController {
    private  static Scanner sc;
    private final DepartmanService ds;

    public DepartmanController() {this.ds = new DepartmanService();}

    public void runDep(){

    }

    public void departmanEkle() {
        sc = new Scanner(System.in);
        System.out.println("Eklemek istediginiz departman adini yaziniz.");
        Departman departman = new Departman(sc.nextLine());
        ds.save(departman);
    }
}