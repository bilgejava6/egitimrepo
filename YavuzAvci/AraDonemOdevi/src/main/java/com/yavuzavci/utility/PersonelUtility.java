package com.yavuzavci.utility;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.ECinsiyet;

import static com.yavuzavci.utility.StaticValues.*;

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

    public static Long silinecekPersonelIdAl(){
        System.out.print("Silmek istediğiniz personelin numarasını giriniz..: ");
        return scanner.nextLong();
    }

    public static int yeniPersonelTuruSec(){
        System.out.println("Oluşturabileceğiniz personel türleri ve kodları aşağıdaki gibidir.");
        System.out.println("1 - Büro Personeli [buro]");
        System.out.println("2 - Genel Müdür [genelmudur]");
        System.out.println("3 - Hizmetli [hizmetli]");
        System.out.println("4 - İnsan Kaynakları Personeli [insankaynaklari]");
        System.out.println("5 - Müdür [mudur]");
        System.out.println("6 - Muhasebe Personeli [muhasebe]");
        System.out.println("7 - Teknik Personel [teknik]");
        System.out.print("Lütfen seçiniz..: ");
        String personelTuru = scanner.nextLine();
        switch (personelTuru.toLowerCase()){
            case "buro":
                return 1;
            case "genelmudur":
                return 2;
            case "hizmetli":
                return 3;
            case "insankaynaklari":
                return 4;
            case "mudur":
                return 5;
            case "muhasebe":
                return 6;
            case "teknik":
                return 7;
            default:
                return -1;
        }
    }
}
