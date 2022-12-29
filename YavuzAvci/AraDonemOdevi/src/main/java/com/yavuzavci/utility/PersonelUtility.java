package com.yavuzavci.utility;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.ECinsiyet;

import static com.yavuzavci.utility.StaticValues.*;

public class PersonelUtility {
    public static ECinsiyet cinsiyetAl(){
        System.out.println("Personelin cinsiyet bilgisini giriniz");
        System.out.println("erkek / kadın için => 1 / 2, diğer durumlar için başka bir sayı seçin.");
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
        System.out.println("Personelin adını ve soyadını giriniz.");
        String adSoyad = scanner.nextLine();
        return adSoyad;
    }

    public static Integer yasAl(){
        System.out.println("Personelin yaşını giriniz.");
        Integer yas = scanner.nextInt();
        return yas;
    }

    public static String telefonAl(){
        System.out.println("Personelin telefon numarasını giriniz.");
        String telefon = scanner.nextLine();
        return telefon;
    }

    public static Departman departmanAl(){
        System.out.println("Departman numarasını giriniz.");
        long id = scanner.nextLong();
        return departmanController.findById(id);
    }

    public static Double maasAl(){
        System.out.println("Personelin alacağı maaşı giriniz.");
        Double maas = scanner.nextDouble();
        return maas;
    }

    public static Long silinecekPersonelIdAl(){
        System.out.print("Silmek istediğiniz personelin numarasını giriniz.");
        Long id = scanner.nextLong();
        return id;
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
        System.out.println("Lütfen seçiniz.");
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

    public static int personelTuruBelirle(String personelTuru){
        switch (personelTuru){
            case "Buro":
                return 1;
            case "GenelMudur":
                return 2;
            case "Hizmetli":
                return 3;
            case "InsanKaynaklariPersoneli":
                return 4;
            case "Mudur":
                return 5;
            case "MuhasebePersoneli":
                return 6;
            case "TeknikPersonel":
                return 7;
            default:
                return -1;
        }
    }

    public static boolean istenCikarmaYetkisiAl(){
        System.out.println("İşten çıkarma yetkisi vermek için E ye basınız.");
        String iYetki = scanner.nextLine();
        switch (iYetki.toUpperCase()){
            case "E":
                return true;
            default:
                return false;
        }
    }

    public static boolean maasTanimlamaYetkisiAl(){
        System.out.print("Maaş tanımlama yetkisi vermek için E ye basınız.");
        String mYetki = scanner.nextLine();
        switch (mYetki.toUpperCase()){
            case "E":
                return true;
            default:
                return false;
        }
    }

    public static boolean odemeYetkisiAl(){
        System.out.println("Ödeme yetkisi vermek için E ye basınız.");
        String oYetki = scanner.nextLine();
        switch (oYetki.toUpperCase()){
            case "E":
                return true;
            default:
                return false;
        }
    }

    /**
     * Hizmetli ve teknik personeller için ortak.
     */
    public static Integer vardiyaSuresiTanimla(){
        System.out.println("Personelin vardiya süresini giriniz.");
        Integer vardiya = scanner.nextInt();
        return vardiya;
    }

    public static String teknikAlanBilgisiAl(){
        System.out.println("Teknik personelin alanını giriniz.");
        String teknikAlan = scanner.nextLine();
        return teknikAlan;
    }
}
