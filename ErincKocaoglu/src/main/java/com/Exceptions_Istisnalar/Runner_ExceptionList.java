package com.Exceptions_Istisnalar;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner_ExceptionList {

    public static void main(String[] args) {
        /**
         * Belli işlemler yapan bir uygulamamaız olsun.
         */
        int s1,s2,toplam,bolme;
        Scanner sc;
        /**
         * Eğer bir hata yoksa döngüden çıksın.
         * Eğer bir sorun oluşmuş ise, döngü devam etsin.
         *
         * Hangi kodun nasıl bir istisna fırlatacağını nasıl anlarım? Nereden bulurum?
         * Kullandığınız method'un içine girerek hata fırlatıp, fırlatmadığına bakarsınız.
         * Peki ne arayacağız..? (throw new) komutunu aramanız yeterlidir.
         */
        boolean isException;
        do{
            try {
                sc = new Scanner(System.in);
                System.out.println("1. Sayiyi girin.");
                s1 = sc.nextInt();
                System.out.println("2. Sayiyi girin.");
                s2 = sc.nextInt();
                bolme = s1 / s2;
                System.out.println("iki sayinin bolumu." + bolme);
                isException = false;
            }catch (InputMismatchException exception) {
                System.out.println("Lutfen Rakam Girin...");
                isException = true;
            }catch (ArithmeticException exception) {
                System.out.println("Islem Hatasi. Lutfen gecerli degerler girin..");
                isException = true;
            }catch (Exception exception) {
                System.out.println("Beklenmeyen Hata. Lutfen IT ile iletisime gecin..");
                System.out.println("Hata.....: " +exception.toString());
                isException = true;
            }finally{
                System.out.println("Her durumda çalısan kisim");
            }
        }while(isException);





        System.out.println("Program sonlandi.");


    }




}
