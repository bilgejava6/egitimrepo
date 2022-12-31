package com.beratacer.utility;

import com.beratacer.repository.entity.Departman;
import com.beratacer.repository.entity.Personel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticValues {
    public static Long personelId=0l;
    public static Long departmanId=0l;
    public static List<Departman> departmanList=new ArrayList<>();
    public static List<Personel> personelList=new ArrayList<>();
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
