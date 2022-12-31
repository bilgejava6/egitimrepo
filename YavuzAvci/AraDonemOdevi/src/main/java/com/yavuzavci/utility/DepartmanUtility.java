package com.yavuzavci.utility;

import com.yavuzavci.entity.Departman;

import static com.yavuzavci.utility.StaticValues.DEPARTMAN_CONTROLLER;
import static com.yavuzavci.utility.StaticValues.SCANNER;

/**
 * Departman işlemlerini kolaylaştırmak amacıyla
 * oluşturulmuş işlevsel sınıf.
 * @author Yavuz AVCI
 */
public class DepartmanUtility {
    public static Departman departmanOlustur(){
        System.out.println("Departmanın adını giriniz.");
        String departmanAdi = SCANNER.nextLine();
        SCANNER.nextLine();
        return new Departman(departmanAdi);
    }

    public static Long silinecekDepartmanIdAl(){
        System.out.println("Silmek istediğiniz personelin numarasını giriniz.");
        Long id = SCANNER.nextLong();
        SCANNER.nextLine();
        return id;
    }

    public static Departman adaGoreDepartmanBul(String ad){
        for(Departman departman : DEPARTMAN_CONTROLLER.findAll()){
            if(departman.getAd().equals(ad))
                return departman;
        }
        return null;
    }
}
