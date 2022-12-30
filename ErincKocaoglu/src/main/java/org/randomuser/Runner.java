package org.randomuser;

import com.google.gson.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) throws Exception{

        System.out.println("******  KULLANICI DATALARI  ******");
        System.out.println("işlem Basladi");
        Scanner sc = null;
        sc = new Scanner(new URL("https://randomuser.me/api/?results=20").openStream(),"UTF-8");
        StringBuilder sb = new StringBuilder();
        String row;
        while (sc.hasNext()) {
            row = sc.nextLine();
            sb.append(row);

        }

        System.out.println("Butun datalar cekildi");


        List<Person> kullaniciListesi = new ArrayList<>();
        Gson gson = new Gson();
        /**
         * elimizde bulunan string halindeki json datayı jsonelement olarak parse ediyoruz.
         */
        JsonElement jsonElement = JsonParser.parseString(sb.toString());
        /**
         * Json elementi, bir jsonData'ya çevirmeliyiz ki, içinden dataları alalım.
         */
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        /**
         * Json object'e çevrilen datanın içinden artık istediğimiz key ile gerekli bilgileri çekebiliriz.
         */
        JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonObject p = jsonArray.get(i).getAsJsonObject();
            Person person = gson.fromJson(p, Person.class);
            kullaniciListesi.add(person);
        }

        //kullaniciListesi.forEach(System.out::println);

        /**
         * Canada'da oturanları listele.
         */

//        kullaniciListesi.stream()
//                .filter(x-> x.getLocation().getCountry().equals("Canada"))
 //               .forEach(System.out::println);

        /**
         * Yaşı 20 ile 45 arasında olan kadınların listesini getir.
         */

//        kullaniciListesi.stream()
 //               .filter(x-> x.getGender().equals("female") &&
 //                       x.getDob().getAge()>20 && x.getDob().getAge()<45)
 //               .forEach(System.out::println);

        /**
         * Norway'de yaşayan insanların yaş ortalaması nedir?
         * 1- Double Array List yapabilirsin. Sonra Average ile ort alırsın.
         * 2- Dob::getAge(), x-> x.getDob.getAge()
         */

//        Double ortalama = kullaniciListesi.stream()
//                .filter(x-> x.getLocation().getCountry().equals("Norway"))
//                .collect(Collectors.averagingInt(x-> x.getDob().getAge()));
//        System.out.println("Norvec yas ort...: " + ortalama);

        /**
         * kullanıcı listesini ülkelere göre map haline getirmek.
         */

        Map<String, List<Person>> countryPersonList;

        countryPersonList = kullaniciListesi.stream()
                .collect(Collectors.groupingBy(
                        p-> p.getLocation().getCountry()
                ));

        countryPersonList.forEach((k,v) -> System.out.println( k +" : "+v));






    }

}
