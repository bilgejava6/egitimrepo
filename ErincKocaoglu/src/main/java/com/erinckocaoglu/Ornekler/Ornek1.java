package com.erinckocaoglu.Ornekler;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ornek1 {

    public static void main(String[] args) {

        List<String> liste = List.of("Ocak","Subat","Mart","Nisan","Mayis","Haziran","Temmuz","Agustos","Eylul","Ekim","Kasım","Aralik");
        /**
         * içinde a harfi geçmeyen ayların listesini yazdıran komut
         */

        liste.stream().filter(x-> !x.toLowerCase().contains("a")).forEach(System.out::println);

        /**
         * Tekrar etmeyen kayıtları tersten sırala
         */

        liste = List.of("Ahmet","Ali","Canan","Tekin","Ulku","Hayri","Deniz","Eren","Kaan","Canan","Deniz","Ali");
        liste.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(g-> System.out.println(g+"-"));

        /**
         *içerisinde a harfi içeren isimleri, K(Integer),V(List<String> şeklinde map yap, yazdır.
         *
         */

        liste = List.of("Ahmet","Ali","Canan","Tekin","Ulku","Hayri","Deniz","Eren","Kaan","Canan","Deniz","Ali");
        Map<Integer,List<String>> newList = liste.stream()
                .filter(x-> x.toLowerCase().contains("a"))
                .collect(Collectors.groupingBy(String::length));
        System.out.println(newList);

    }



}
