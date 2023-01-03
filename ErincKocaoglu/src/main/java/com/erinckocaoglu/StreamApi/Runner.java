package com.erinckocaoglu.StreamApi;

import java.lang.StackWalker.Option;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Runner {
    public static void main(String[] args) {
        /**
         * 		19.12.2022 Pazartesi 11:30  ==> StreamAPI Başlangıç
         *
         *
         * Kullanıcılardan almış olduğumuz datalar bir şekilde kayıt altına alınmalı.
         * Ve gerekli olduğu zamanlarda tekrar çağırılarak kullanılmalı.
         *
         * Dataların kalıcı olarak kayıt edildiği uygulamalara, DataBase adı verilir.
         * Bu uygulamalarla datalar uzun süreli saklanır ve yedeklenir.
         *
         * Dataların ihtiyaca göre işlenmeye ihtiyacı vardır.
         * Bu nedenle, gerekli olduğunda farklı sorgularla çağırılmalıdırlar.
         *
         * Örn;
         *  --> Bir kişiye ait sepet bilgisini görmek istiyoruz.
         *  --> Bir kullanıcının son 3 ayda yaptığı alışverişlerin toplam tutarının
         *  	tüm müşteriler içindeki oranına ihtiyacımız olsun.
         *
         * Bu işlemlerin DataBase üzerinden yapılması, çok fazla istek atmaya ve
         * sistemi yavaşlatmaya neden olabilir.
         *
         * 			*** Veri tabanından gerekli olan bilgileri tek seferde alınarak
         * 				Listelerin içerisine konur.
         *
         * 	!! DİKKAT !!
         * 		Ben, daha çok listeler ile çalışmalıyım ki,
         * 		daha performanslı kodlar yazabileyim.
         * 		Ancak, burada dikkat edilmesi gereken durum,
         * 		benim listeleri MÜKEMMEL bir şekilde kullanabiliyor olmam lazım.
         *
         * 		Stream api, bizim ihtiyacımız olan listelerin aranması, yönetilmesi için gerekli,
         * 		Özelleştirilmiş bir sınıftır.
         *
         */

        //count = 0;
        Stream<String> bosStream = Stream.empty();  // içi boş bir Stream oluşturduk.
        //count = 1;
        Stream<String> tekilStream = Stream.of("Pazartesi"); // içinde bir eleman barındıran Stream.
        //count = 4;
        Stream<Double> sayilar = Stream.of(22d,1d,5d,8.5d);
        List<String> gunler = List.of("pzt","sali","car","per","cuma","ctes","pazr");

        /**
         * Tüm listelerde stream miras olarak alınmaktadır. Bu nedenle tüm listeler stream'e döndürülebilir.
         *
         */
        //Örn:  gunler.stream();
        /**
         * List -> Stream'e çevirelim ve içindeki parametreleri dönelim.
         */

        Stream<String> gunlerStream = gunler.stream();
        //gunlerStream.forEach(System.out::println);
        //gunlerStream.forEach(g->System.out.println(g));
        gunlerStream.forEach(g->{
            System.out.println("once yapilacaklar");
            System.out.println(g);
            System.out.println("ek islemler.");
        });

        /**
         * Sonsuz Streamler
         */

        Stream<Double> rastgeleRandomSayilar = Stream.generate(Math::random);
        //rastgeleRandomSayilar.forEach(System.out::println);
        Stream<Integer> fonksiyonSayilar = Stream.iterate(1, n -> n+2);
        //fonksiyonSayilar.forEach(System.out::println);
        fonksiyonSayilar = Stream.iterate(1,n -> n<20, n -> n+2);
        fonksiyonSayilar.forEach(p->System.out.println(p));

        /**
         * Method'lar...
         *
         * 	count	-> eleman sayisi.
         * 	min,max -> en küçük, en büyük değer..
         * 	forEach -> bileşenlerini dönmek için.
         *
         *
         */

        System.out.println("Gunler count....: " + sayilar.count());
        //System.out.println("Rastgele sonsuz sayi count....: " + rastgeleRandomSayilar);

        Stream<String> isimler = Stream.of("Erinc","Sophie","Orkun","Hazal","nil");
        //Bir String ifade dizisinde isim uzunluğu en küçük olanı versin.
        Optional<String> minIsim = isimler.min((s1,s2) -> s1.length()-s2.length());
        minIsim.ifPresent(System.out::println);


        /**
         *
         *
         *
         */

        String [] harfler = new String [] {"E","r","i","n","c"};
        String isim="";
        for(String harf : harfler)
            isim += harf;
        System.out.println("isim....: " + isim);

        Stream<String> streamHarfler = Stream.of("E","r","i","n","c");
        String streamIsim = streamHarfler.reduce("", (ad,harf)-> ad+harf);
        System.out.println("Reduce....: " + streamIsim);
        /**
         * {3,5,8,2}
         * a -> Belli bir baslangıcı olan ve dönen sonucu tutan deger.
         * 1,(a,b) -> a*b
         *
         * 1. adımda -> a=1;
         * 2. adımda a*b => 1*3
         * 3. adımda -> a=3;
         * 4. adımda a*b => 3*5
         * 5. adımda -> a=15;
         *
         */

        Stream<Integer> streamInt = Stream.of(3,5,8,2);
        Integer sonuc = streamInt.reduce(1, (a,b) -> a*b);
        System.out.println("Sonuc.....: "+ sonuc);

        Stream<Integer> streamInt1= Stream.of(3,5,8,2);
        Integer sonuc1= streamInt1.reduce(1, (a,b) -> a+b);
        System.out.println("Sonuc1.....: "+ sonuc1);

        /**
         * BinaryOperator
         *
         */
        BinaryOperator<Integer> op = (a,b) -> a*b;
        Stream<Integer> streamInt2 = Stream.of(3,5,8,2);
        streamInt2.reduce(op).ifPresent(System.out::println);
        Stream<Integer> bosDizi = Stream.of(4,3,2);
        bosDizi.reduce(op).ifPresentOrElse(p->{
            System.out.println("Sonuc2....: "+p);
        },()->{
            System.out.println("Herhangi bir sonuc uretilemedi.");
        });

        Stream<String> isimDizi = Stream.of("b","a","h","a","r");
        /**
         * collect -> Bir koleksiyonun, başka bir koleksiyona dönüşmesine yarar.
         */

        TreeSet<String> setIsim = isimDizi
                .collect(
                        TreeSet::new,
                        TreeSet::add,
                        TreeSet::addAll
                );
        System.out.println("Set isimler...: " +setIsim);


        Stream<String> isimDizisi1 = Stream.of("b","a","h","a","r");
        TreeSet<String> setIsim2 = isimDizisi1.collect(Collectors.toCollection(TreeSet::new));
        System.out.println("set isimler2.....: "+setIsim2);

        /**
         * Stream içinde en önemli kullanımlardan olan filter , istediğimiz liste içinde
         * belli kriterlere göre  filtreleme yapmamza olanak sağlar
         */

        Stream<String > urunListesi = Stream.of("Utu","Duy","Bilgisayar","Telefon","Televizyon","Buzdolabi","Bulasik Makinesi");
        //adı T ile başlayan ürünleri getir.
        //urunListesi.filter(u->u.startsWith("T")).forEach(System.out::println);
        urunListesi.filter(u->u.length()>10 || u.length()<4).forEach(System.out::println);

        /**
         * Bir liste içinde tekrar eden kayıtların gösterilmesi istenmiyor ise distinct kullanılır.
         * -> String, Integer, gibi tekli veri tutan tipleri kullanmak anlamlı iken,
         * Sınıf tipinde ve içinde bir çok alanı barındıran nesneleri kullandığımızda işler karışıyor gibi görünebilir.
         * Buradaki iki nesnenin birebir aynı olması gerektiğini unutmayın.
         *
         */

        Stream<String> musteriListesi = Stream.of("Ali","Deniz","Bahar","Gunes","Ali","Deniz","Bekir");
        musteriListesi.distinct().forEach(System.out::println);

        /**
         * Limit, sonsuz döngülerde, işlemin kısıtlı kalmasını sağlamak için kullanılır.
         * DÖNGÜ SAYISINI BELİRTİR.!!
         *
         * skip, fonksiyonun belli miktardaki adımlarını atlayarak devam etmesini sağlar.
         * 1. adım -> ilk adımda fonksiyonunn sonsuz gittiğini düşünelim -> 5, 10, 20, 40, 80, 160, 320,.....
         * 2. adım -> limit(6) -> 5, 10, 20, 40 , 80, 160
         * 3. adım -> skip(2) -> 20,40,80,160
         * 4. adım -> limit(3) -> 20,40,80
         */
        Stream<Integer> sayilarI = Stream.iterate(5, s -> s*2);
        sayilarI.skip(2).limit(5).forEach(System.out::println);


        //*********
        /**
         * Elimizde, bir firmanın günlük ürün satislari ile ilgili bilgiler olsun.
         * A ürünü -> List<Satis> satış listesi şeklinde bilgiler olsun.
         */
        Stream<String> sehirler = Stream.of("Ankara","Istanbul","Izmir","Bursa","Denizli");
        sehirler.map(String::length).forEach(System.out::println);
        List<Urun> AurunSatisListesi = Arrays.asList(new Urun(), new Urun(),new Urun());
        List<Urun> BurunSatisListesi = Arrays.asList(new Urun());
        List<Urun> CurunSatisListesi = Arrays.asList(new Urun(), new Urun(), new Urun(),new Urun());

        Stream<List<Urun>> urunListesi2 = Stream.of(AurunSatisListesi,BurunSatisListesi,CurunSatisListesi);
        urunListesi2.map(List::size).forEach(System.out::println);

        /**
         * Sorting
         * bir liste içinde belli özelliklere göre sıralama işlemleri yapabiliriz.
         * sorted() -> a....Z ,  0....9
         * sorted(Comparator.reverseOrder()) -> Z....a , 9....0
         */

        Stream<String> isimListesi = Stream.of("Canan","Zeynep","Gumus","Eren","Ayse","Tekin");
        isimListesi.sorted().forEach(System.out::println);
        isimListesi = Stream.of("Canan","Zeynep","Gumus","Eren","Ayse","Tekin");
        isimListesi.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        /**
         * Stream -> Collecting Results
         */

        System.out.println("********   Collecting Results   ********");
        System.out.println();
        /**
         * var nedir?
         * var -> Java 10 ile gelen değişken tanımlama yöntemidir.
         * "var", temel olarak bir tip değildir.
         * Siz değişken türüne göre hangi atamayı yaparsanız o değere dönüşür.
         *
         */

        var sayiiii = 45;
        var ifade = "ifade";
        var olduMu = true;

        var sayiListesi = Arrays.asList(1,2,3,4,5,6,7);

        var gunListesi = Stream.of("Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi","Pazar");
        String sGunler = gunListesi.collect(Collectors.joining("-"));
        System.out.println(sGunler);


        //***********
        gunListesi = Stream.of("Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi","Pazar");
        Double dGunlerAvg = gunListesi.collect(Collectors.averagingDouble(String::length));
        System.out.println("Gunlerin uzunlukları ortalaması...: " + dGunlerAvg);



        //************
        gunListesi = Stream.of("Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi","Pazar");
        TreeSet<String> tsGunler = gunListesi
                .filter(g-> g.startsWith("C"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("C ile baslayan gunler...: "+ tsGunler);



        //*********
        gunListesi = Stream.of("Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi","Pazar");
        Map<String, Integer> mapGunler =
                gunListesi.collect(Collectors.toMap(g-> g, g-> g.startsWith("C") ? g.length() : 0));
        System.out.println("Gunlerin uzunluklari...: "+mapGunler);


        //*********
        /**
         * Key -> Value
         * 4 = ["sali","cuma"]
         * 5 = ["pazar"]
         * 8 = ["carsamba","persembe"]
         */
        gunListesi = Stream.of("Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi","Pazar");
        Map<Integer,List<String>> mapListGunler =
                gunListesi.collect(Collectors.groupingBy(String::length));
        System.out.println("Gunlerin uzunluklari....:" + mapListGunler);


        var urunList =
                Stream.of(new Urun("A Marka", "Seker"),
                        new Urun("A Marka", "Un"),
                        new Urun("B Marka", "Yag"),
                                new Urun("C Marka", "Cikolata"));
        Map<String,List<Urun>> markaGrupListesi =
                urunList.collect(Collectors.groupingBy(Urun::getMarka));
        System.out.println("Marka Grup Listesi....: "+markaGrupListesi);


        //************

        gunListesi = Stream.of("Pazartesi","Sali","Carsamba","Persembe","Cuma","Cumartesi","Pazar");
        TreeMap<String,List<String>> glist=
                gunListesi.collect(
                        Collectors.groupingBy(
                                g-> g.substring(0,1),
                                TreeMap::new,
                                Collectors.toList()
                        )
                );
        System.out.println("Gunlerin uzunluklari...: "+ glist);








    }//Main Sonu

}
