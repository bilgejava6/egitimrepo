package com.Exceptions_Istisnalar;

import java.util.List;
import java.util.Scanner;

public class RunnerOdev {
    public static void main(String[] args) {
        /**
         * ClassCastException
         * IndexOutOfBoundException
         * NullPointerException
         *
         * bu üçü ile ilgili örnkeler içieren bir try bloğu yazınız.
         */

        /**
         *
         * ClassCastException  ->
         * Açılamanı buraya yaz. Örneğini aşağıya yap. sonrakine geç...
         * ClassCastException : bir nesnenin başka bir sınıfa "Cast" edilmesi sırasında oluşan bir hatadır.
         * Bu hata, elimizdeki nesnenin, istenen diğer sınıfa dönüştürülemeyeceğini anlatan hata çıktısıdır.
         */
        Scanner sc;

          boolean isException;
//        do{
//            try {
//                sc = new Scanner(System.in);
//                System.out.println("kelime gir de rakam alacagını zannet :)");
//
//                Object kelime = new String(sc.nextLine());
//                System.out.println((Integer) kelime);
//                isException = false;
//            } catch (ClassCastException e) {
//                System.out.println("Bu deger buna Cast edilemez.");
//                System.out.println(e.getMessage());
//                isException = true;
//            } finally {
//                System.out.println("Her durumda bol sans.");

//            }
//        }while(isException);


        /**
         * IndexOutOfBoundException  ->
         *  Java'da, "Dizi" veya "Liste" lerde istenilen index değerini çağırmaya çalışırken,
         *  istenilen index değeri sınırı aştığında görülen hata çıktısıdır.
         */


//        String [] menu ={"Lahmacun", "Köfte", "Balik"};
//        do{
//            try{
//                System.out.println("Menuden yemek seciniz.");
//                sc = new Scanner(System.in);
//                System.out.println(menu[sc.nextInt()]);
//                isException = false;
//            }catch (IndexOutOfBoundsException e) {
//                System.out.println("O kadar yemek mi var la orda dingil?");
//                System.out.println("Hata...: "+e.toString());
//
//                isException = true;
//            } finally {
//                System.out.println("Secimlerimiz her durumda bizi yansitir yegen. ");
//            }
//        }while(isException);

        /**
         * NullPointerException  ->
         *  Bu hataya neden olan durum,
         *  bir değişkenin ya da nesnenin belirtilen amaç için kullanılamayacak derecede "null" değer almasıdır. Bu hatayı çözmek için,
         *  değişkenin ya da nesnenin geçerli bir değer alması gerekmektedir.
         */

        do{
            try{
                sc = new Scanner(System.in);
                System.out.println("Datli olarak ne yersin gocum?");
                List menu2 = null;
                System.out.println(menu2.get(sc.nextInt()));
                isException =false;
            }catch (NullPointerException e){
                System.out.println("Bi doymadın lan pavyoncu. Yok sana datli.");
                System.out.println("Hata...: "+e.toString());
                isException = true;
            }finally {
                System.out.println("Secimlerin de her durumda pavyoncu. Cikislar sagdan...");
            }
        }while(isException);












    }
}
