package com.Exceptions_Istisnalar;

import java.util.Scanner;

public class Runner {
        public static void main(String[] args) {

                /**
                 * Uygulamalarımız her daim sorun çıkartma kapasitesine sahiptir.
                 * Özellikle, kullanıcı ile etkileşime geçtiğimiz tüm kodları dikkatle inceleyip,
                 * hata yakalama işlemlerine öncelik vermeliyiz.,
                 * Syntax:
                 *      try{ -> try keyword'u kullanılır.
                 *       --> body, hatanın olacağını düşündüğünüz kod bloğunu buraya yazıyoruz.
                 *      } catch(Exception ex){-> catch, bir istisna olduğunda onu yakalayacak kısım
                 *       --> yakalanan hata, hata türüne göre işleme tabi tutulur.
                 *       İstisnanın türü catch parantexleri içinde talep edilir. (Exception, RunTimeException v.s.)
                 *       Bir hata olduğunda ne yapılması gerektiği burada işlenir.
                 *      }finaly{ --> hata olsun yada olmasın yürütülmesi gereken ilemler, adımlar var ise,
                 *       bunlar burada kodlanmalıdır.
                 *      }
                 */

                System.out.println("************************");
                System.out.println("***  Hesap Makinesi ****");
                System.out.println("************************");
                System.out.println("1- Toplama");
                System.out.println("2- Cikartma");
                System.out.println("3- Carpma");
                System.out.println("4- Bolme");
                System.out.println("0- Cikis");
                Scanner sc = new Scanner(System.in);
                System.out.println("Secim yap lutfen.");
                try {
                        int secim = sc.nextInt();
                }catch (Exception exception) {
                        System.out.println("Lutfen Rakam Giriniz...");
                }
                System.out.println("Program Sonlandı.");

        }


}
