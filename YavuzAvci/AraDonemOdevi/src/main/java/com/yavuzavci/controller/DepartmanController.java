package com.yavuzavci.controller;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.service.DepartmanService;

import java.util.List;
import java.util.Objects;

import static com.yavuzavci.utility.DepartmanUtility.*;
import static com.yavuzavci.utility.StaticValues.SCANNER;
import static com.yavuzavci.utility.StaticValues.sistemSaatiniAl;

/**
 * Kullanıcıların departman bilgileriyle işlem yapmak için
 * eriştiği katman.
 */
public class DepartmanController {
    private final DepartmanService departmanService;

    public DepartmanController(){
        departmanService = new DepartmanService();
    }

    public void save(){
        Departman departman = departmanOlustur();
        SCANNER.nextLine();
        departmanService.save(departman);
    }
    public void update(){
        if(departmanService.findAll().isEmpty()){
            System.out.println("HATA: Sistemde kayıtlı departman bulunmamaktadır.");
            return;
        }
        System.out.print("Bilgilerini güncellemek istediğiniz departmanın numarasını giriniz..: ");
        long id = SCANNER.nextLong();
        SCANNER.nextLine();
        Departman departman = departmanService.findById(id);
        if(Objects.isNull(departman)){
            System.out.println("HATA: Departman sistemde kayıtlı değildir.");
            return;
        }
        System.out.println("Departmanın yeni adını giriniz.");
        String deparmanAdi = SCANNER.nextLine();
        departman.setAd(deparmanAdi);
        departman.setUpdateDate(sistemSaatiniAl());
        departmanService.update(departman);
    }
    public void delete() {
        if(departmanService.findAll().isEmpty()){
            System.out.println("HATA: Sistemde kayıtlı departman bulunmamaktadır.");
            return;
        }
        Long id = silinecekDepartmanIdAl();
        SCANNER.nextLine();
        departmanService.delete(id);
    }
    public Departman findById(Long id){
        return departmanService.findById(id);
    }
    public List<Departman> findAll() {
        return departmanService.findAll();
    }

}
