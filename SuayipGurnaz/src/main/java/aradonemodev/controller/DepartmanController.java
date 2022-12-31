package aradonemodev.controller;

import aradonemodev.repository.entity.*;
import aradonemodev.service.DepartmanService;

import java.util.Scanner;

import static aradonemodev.utility.PtsUtility.*;
import static aradonemodev.utility.PtsUtility.intDegerAlma;

public class DepartmanController {
    private static Scanner sc;
    private final DepartmanService departmanService;

    public DepartmanController() {
        departmanService=new DepartmanService();
    }

    public void save() {
        System.out.println("***** DEPARTMAN EKLEME *****");
        System.out.println();
        String ad = stringDegerAlma("Lütfen departman adını giriniz...: ");
        for(int i=0; i<departmanList.size(); i++){
            if(departmanList.get(i).getAd().equalsIgnoreCase(ad)) {
                System.out.println("Bu departman daha önceden eklenmiş...");
                break;
            }
        }
        departmanService.save(new Departman(ad));
    }// save sonu

    public void update() {
        System.out.println("***** DEPARTMAN BİLGİSİ GÜNCELLEME *****");
        System.out.println();
    }

    public void delete() {
        System.out.println("***** DEPARTMAN SİLME *****");
        System.out.println();
        long id=intDegerAlma("Silinecek departmanın id numarasını giriniz:");
        for (int i = 0; i < departmanList.size(); i++) {
            if(departmanList.get(i).getId().equals(id)){
                departmanService.delete(id);
                break;
            }
        }
        System.out.println("Silinmesini istediğiniz departman, mevcut departmanlar arasında bulunamadı...");
    }

    public void findAll() {
        System.out.println("***** DEPARTMAN LİSTESİ *****");
        System.out.println();
        for (Departman departman : departmanService.findAll()) {
            System.out.println("Departman adı...: "+ departman.getAd());
            System.out.println("Departman personel sayısı...: "+ departman.getPersonelSayisi());
            System.out.println("Departman id no...: "+ departman.getId());
        }
    }

    public Departman findById() {
        System.out.println("***** ID'YE GÖRE DEPARTMAN BULMA *****");
        System.out.println();
        long id=intDegerAlma("Bulunacak departmanın id numarasını giriniz:");
        return departmanService.findById(id);
    }
}
