package com.yavuzavci.utility;

import com.yavuzavci.entity.Departman;

import static com.yavuzavci.utility.StaticValues.departmanController;
import static com.yavuzavci.utility.StaticValues.scanner;

public class DepartmanUtility {
    public static Departman departmanOlustur(){
        System.out.println("Departmanın adını giriniz.");
        String departmanAdi = scanner.nextLine();
        scanner.nextLine();
        return new Departman(departmanAdi);
    }

    public static Long silinecekDepartmanIdAl(){
        System.out.println("Silmek istediğiniz personelin numarasını giriniz.");
        Long id = scanner.nextLong();
        scanner.nextLine();
        return id;
    }

    public static Departman adaGoreDepartmanBul(String ad){
        for(Departman departman : departmanController.findAll()){
            if(departman.getAd().equals(ad))
                return departman;
        }
        return null;
    }
}
