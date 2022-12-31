package com.beratacer.utility;

import static com.beratacer.utility.StaticValues.stringScanner;
import static java.lang.Integer.parseInt;

public class MenuValues {

    public int anaMenu(){
        System.out.println("**********************************");
        System.out.println("******PERSONEL TAKIP SISTEMI******");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("1 - Personel Islemleri...");
        System.out.println("2 - Muhasebe Islemleri...");
        System.out.println("3 - Raporlamalar...");
        return parseInt(stringScanner("Yapmak istediğiniz islemi seciniz : "));
    }
    public int personelIslemleri(){
        System.out.println("***Personel Islemleri***");
        System.out.println();
        System.out.println("1 - Personel ekleme..");
        System.out.println("2 - Personel listesi..");
        System.out.println("3 - Personel düzenleme..");
        System.out.println("4 - Departman ekleme..");
        System.out.println("5 - Departman listesi..");
        return parseInt(stringScanner("Yapmak istediğiniz islemi seciniz : "));
    }
    public int muhasebeIslemleri(){
        System.out.println("***Muhasebe Islemleri***");
        System.out.println();
        System.out.println("1 - Maas personel tanimlama..");
        System.out.println("2 - Odeme listesi..");
        return parseInt(stringScanner("Yapmak istediğiniz islemi seciniz : "));
    }
    public int raporlamalar(){
        System.out.println("***Raporlamalar***");
        System.out.println();
        System.out.println("1 - Departman personel listesi..");
        System.out.println("2 - En cok personel bulunan departman..");
        System.out.println("3 - Departmanlara gore maas ortalamalari..");
        System.out.println("4 - Mudurlerin sorumlu oldugu departman listesi..");
        System.out.println("5 - Kayit tarihlerine göre personellerin sirali listesi");
        System.out.println("6 - Aynı gun içinde ise baslayan personellerin listesi");
        return parseInt(stringScanner("Yapmak istediğiniz islemi seciniz : "));
    }
    public static int pozisyonlar(){
        System.out.println("***Pozisyonlar***");
        System.out.println();
        System.out.println("1 - Genel Mudur");
        System.out.println("2 - Mudur");
        System.out.println("3 - Insan Kaynaklari");
        System.out.println("4 - Buro Personeli");
        System.out.println("5 - Hizmetli");
        System.out.println("6 - Muhasebe");
        System.out.println("7 - Teknik Personel");
        return parseInt(stringScanner("Eklemek istediginiz pozisyonu seciniz : "));
    }
}
