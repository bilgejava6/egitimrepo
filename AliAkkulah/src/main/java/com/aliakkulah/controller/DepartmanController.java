package com.aliakkulah.controller;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.service.DepartmanService;

import java.util.List;
import java.util.Scanner;

import static com.aliakkulah.utility.Utility.departmanListesi;

public class DepartmanController {
    private  static Scanner sc;
    private final DepartmanService ds;

    public DepartmanController() {this.ds = new DepartmanService();}

    public void baslangicDepartmanlariEkle() {
        Departman dp0 = new Departman("Departmani Yok");
        departmanListesi.add(dp0);
        Departman dp1 = new Departman("Buro");
        departmanListesi.add(dp1);
        Departman dp2 = new Departman("Genel Mudur");
        departmanListesi.add(dp2);
        Departman dp3 = new Departman("Hizmetli");
        departmanListesi.add(dp3);
        Departman dp4 = new Departman("Insan Kaynaklari");
        departmanListesi.add(dp4);
        Departman dp5 = new Departman("Mudur");
        departmanListesi.add(dp5);
        Departman dp6 = new Departman("Muhasebe");
        departmanListesi.add(dp6);
        Departman dp7 = new Departman("Teknik");
        departmanListesi.add(dp7);
    }

    public void departmanEkle() {
        sc = new Scanner(System.in);
        System.out.println("Eklemek istediginiz departman adini yaziniz.");
        Departman departman = new Departman(sc.nextLine());
        ds.save(departman);
    }

    public void findAll() {ds.findAll().forEach(System.out::println);}

    public void departmanPersonelListesi(int depId) {
        Departman departman = new Departman();
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getId() == depId) {
                departman = departmanListesi.get(i);
                break;
            }
        }
        if(departman != null){
            System.out.println(departman.getAd() + " departmani personel listesi:");
            ds.departmanPersonelListesi(departman).forEach(System.out::println);
        }else
            System.out.println("Girdiginiz id'ye ait bir departman bulunamadi.");
    }

    public void enCokPersonelliDepartman(){
        List<Departman> departmanList = ds.enCokPersonelliDepartman();
        if(departmanList.size() == 1){
            System.out.println("En cok personel bulunduran departman: " + departmanList.get(0).getAd());
            System.out.println("Personel sayısı = " + departmanList.get(0).getPersonelList().size());
        }else{
            System.out.print("En cok personel bulunduran departmanlar: ");
            departmanList.forEach(System.out::println);
            System.out.println("Personel sayısı = " + departmanList.get(0).getPersonelList().size());
        }


    }
}