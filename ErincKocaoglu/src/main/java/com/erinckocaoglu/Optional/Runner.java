package com.erinckocaoglu.Optional;

import java.util.Optional;



public class Runner {

    static int sayi = 5;
    static Ogrenci ogr = new Ogrenci();
    static Ogrenci ogr2;

    public static void main(String[] args) {
        /**
         * Primitive Data Type -> int,char,float,double,boolean default değere
         * sahiptirler.
         *
         * References Data Type -> Sınıf tipleridir ve değişkenleri tanımlandığında
         * değer olarak null alırlar. Atama yapıldığında (new ile) oluşan nesnenin
         * adresi atanır.
         *
         * Reference Data Type'lar null değer dönebileceğinden, yeni adreslerinin işaret
         * ettiği bir değer olmadığından, sınıfların içindeki değerlere erişim olmayacak
         * ve NullPointerException istisnası fırlatacaktır.
         *
         *
         */

        System.out.println("sayi......: " + sayi);
        System.out.println("1. Ogrencinin adi......: " + ogr.getAd());
        // System.out.println("1. Ogrencinin adi......: " + ogr2.getAd());

        System.out.print("Ortalaman kaç....: ");
        System.out.println(ortalama());
        Optional<Double> ort = ortalama2(80,60,90);
        if(ort.isPresent())
            System.out.println(ort.get());
        else
            System.out.println("Sinava girilmedi.");

        ort.ifPresent(System.out::println);
        ort.ifPresent(p->{
            System.out.println("Ortalama....: "+ p);
        });
        ort.ifPresentOrElse(p->{
            System.out.println("Ortalama.....: " + p);
        }, ()->{
            System.out.println("Ortalama yok.");  // 33. satırdaki ortalamaları sil ve bunu gör.
        });

        /**
         *	not=59;
         *if(not>50) gecti.
         *else kaldı.
         *
         *not>50 ? gecti : kaldı;
         *
         */
        /**
         * Bu işlem ogr2'yi kontrol ederek null olup olmama durumuna göre optional üretir.
         * Ancak, bu kullanım uzundur...
         */
        Optional optionalOgr = ogr2==null ? Optional.empty() : Optional.of(ogr2);
        /**
         * Yukarıdaki işleme göre daha kolay bir kullanım..
         *
         */
        optionalOgr = Optional.ofNullable(ogr2);
        Optional<Double> ort3 = ortalama2();
        /**
         * Bir değere ulaşmak yada okumak istiyorsunuz, ancak değer yok.
         * Böyle durumlarda default bir değer kullanmak gerekebilir.
         * Bunun için orElse kullanmak doğru olacaktır.
         */
        System.out.println(ort3.orElse(Double.NaN));
        System.out.println(ort3.orElse(50d));

        Optional<String> isim = Optional.empty();
        System.out.println(isim.orElse("Girilmemis"));
        isim = Optional.of("Mehmut");
        System.out.println(isim.orElse("Girilmemis"));


    }

    private static double ortalama(double... notlar) {
        double ort = 0;
        for (double not : notlar) {
            ort += not;

        }
        if(notlar.length>0)
            ort = ort / notlar.length;

        return ort;
    }

    private static Optional<Double> ortalama2(double... notlar) {
        /**
         * Ogrencinin notu yok ise,
         */
        if(notlar.length==0) return Optional.empty();
        double ort = 0;
        for (double not : notlar) {
            ort += not;

        }
        ort = ort / notlar.length;
        return Optional.of(ort);
    }



}
