package com.aliulas.controller;

import com.aliulas.repository.entity.Departman;
import com.aliulas.repository.entity.Mudur;
import com.aliulas.repository.entity.Personel;
import com.aliulas.service.DepartmanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.aliulas.utility.StaticValues.departmanListesi;
import static com.aliulas.utility.StaticValues.personelListesi;

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
        //System.out.println("Calisan Sayisini giriniz.");
        //departman.setCalisanSayisi(sc.nextInt());
        List<Personel> personelListesi = new ArrayList<>();
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
    public void departmanPersonelListesi(String dep){
            for(int i = 0; i< departmanListesi.size();i++){
                if(departmanListesi.get(i).getAd().equals(dep)){
                    List<Personel> pList = departmanListesi.get(i).getPersonelListesi();
                    for(int j = 0;j < pList.size();j++){
                        System.out.println((j+1) +". Personel: " + pList.get(j).getAd() +" "+ pList.get(j).getSoyad() +" "+ pList.get(j).getPozisyon());
                    }
                }
            }
         }
    public void enCokPersonelBulunanDepertman(){
        int max = 0;
        Departman maxP = new Departman();
        for (int i = 0; i<departmanListesi.size();i++){
           if(departmanListesi.get(i).getPersonelListesi().size() > max)
               max = departmanListesi.get(i).getPersonelListesi().size();
               maxP = departmanListesi.get(i);
        }
        System.out.println("En çok personel bulunan departman: " + maxP.getAd());
    }

    public void departmanlaraGoreMaasOrtalamasi(){
        float ortMaas = 0;
        for (int i = 0; i<departmanListesi.size(); i++){
            for(int j= 0; j<departmanListesi.get(i).getPersonelListesi().size();j++){
                ortMaas += departmanListesi.get(i).getPersonelListesi().get(j).getMaas();
            }
            ortMaas = ortMaas / departmanListesi.get(i).getPersonelListesi().size();
            System.out.println(departmanListesi.get(i).getAd() + " departmanının maaş ortalaması: " + ortMaas);
        }
    }

    public void mudurSorumlu(){
        Mudur mudur = null;
        for(int i = 0; i<departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equals("Mudur")){
                for(int j= 0;j<departmanListesi.get(i).getPersonelListesi().size();j++)
                    mudur = (Mudur) departmanListesi.get(i).getPersonelListesi().get(j);

                System.out.println(personelListesi.get(i).getDepartman()+"Departmanından "+personelListesi.get(i).getAd()+
                        " Müdürünün sorumlu olduğu departman: "+mudur.getSorumluOlduguDepartman());
            }
        }
    }
}

