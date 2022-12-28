package com.yavuzavci.utility;

import static com.yavuzavci.utility.StaticValues.departmanController;
import static com.yavuzavci.utility.StaticValues.scanner;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.ECinsiyet;

public class PersonelUtility {
    public static ECinsiyet cinsiyetAl(){
        System.out.println("Personelin cinsiyet bilgisini giriniz");
        System.out.print("erkek / kadın için => 1 / 2, diğer durumlar için başka bir sayı seçin..: ");
        int secim = scanner.nextInt();
        scanner.nextLine();
        switch (secim){
            case 1:
                return ECinsiyet.ERKEK;
            case 2:
                return ECinsiyet.KADIN;
            default:
                return ECinsiyet.DIGER;
        }
    }

    public static String adSoyadAl(){
        System.out.print("Personelin adını ve soyadını giriniz..: ");
        return scanner.nextLine();
    }

    public static Integer yasAl(){
        System.out.print("Personelin yaşını giriniz..: ");
        return scanner.nextInt();
    }

    public static String telefonAl(){
        System.out.print("Personelin telefon numarasını giriniz..: ");
        return scanner.nextLine();
    }

    public static Departman departmanAl(){
        System.out.print("Departman numarasını giriniz..: ");
        long id = scanner.nextLong();
        return departmanController.findById(id);
    }

    public static Double maasAl(){
        System.out.print("Personelin alacağı maaşı giriniz..: ");
        return scanner.nextDouble();
    }
}
