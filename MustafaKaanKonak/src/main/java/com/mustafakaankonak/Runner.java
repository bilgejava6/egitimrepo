package com.mustafakaankonak;

import java.util.HashMap;
import java.util.Map;

import com.mustafakaankonak.Utility.BuroPersoneli;
import com.mustafakaankonak.Utility.GenelMudur;
import com.mustafakaankonak.Utility.Hizmetli;
import com.mustafakaankonak.Utility.IKPersoneli;
import com.mustafakaankonak.Utility.Mudur;
import com.mustafakaankonak.Utility.MuhasebePersoneli;
import com.mustafakaankonak.Utility.Personel;
import com.mustafakaankonak.Utility.TeknikPersonel;

public class Runner {
    static Map<Personel,Integer> personeller = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("KLASJDLGK");
        menuOlustur();
        personelEkle("Hasan");
        personelListesi();
    }




    public static void menuOlustur() {

        System.out.println("*****************************");
        System.out.println("***PERSONEL TAKİP SİSTEMİ*****");
        System.out.println("*****************************");
        System.out.println("1. Personel İşlemleri");
        System.out.println("  1.1 Personel Ekleme");
        System.out.println("  1.2 Personel Listesi");
        System.out.println("  1.3 Personel Düzenleme");
        System.out.println("  1.4 Departman Ekleme");
        System.out.println("  1.5 Departman Listesi");
        System.out.println("2. Muhasebe İşlemleri");
        System.out.println("  2.1 Maaş Personel Tanımlama");
        System.out.println("  2.2 Ödeme Listesi");
        System.out.println("3. Raporlamalar");
        System.out.println("  3.1 Departman Personel Listesi.");
        System.out.println("  3.2 En Çok Personel Bulunduran Departman.");
        System.out.println("  3.3 Departmanara göre maaş ortalamaları.");
        System.out.println("  3.4 Kayıt tarihlerine göre personellerin sıralı listesi.");
        System.out.println("  3.5 Müdürlerin sorumu olduğu departman listesi.");
        System.out.println("  3.6 Aynı gün içinde işe başlayan personellerin listesi.");
    }

    public static void personelEkle(String isim){
        int i = 0;

        Personel personel = new Personel(isim,i);
        personeller.put(personel, i);
        i++;


    }
    public static void personelListesi() {
        System.out.println(personeller);
    }

}