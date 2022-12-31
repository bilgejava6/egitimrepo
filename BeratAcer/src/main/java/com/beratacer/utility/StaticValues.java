package com.beratacer.utility;

import java.util.Scanner;

public class StaticValues {
    public static Long personelId=0l;
    public static Long departmanId=0l;
    static Scanner scanner=new Scanner(System.in);

    public static String stringScanner(String string){
        System.out.print(string);
        return scanner.nextLine();
    }
    public static Double doubleScanner(String string){
        System.out.print(string);
        return scanner.nextDouble();
    }
    public static Long longScanner(String string){
        System.out.print(string);
        return scanner.nextLong();
    }
}
