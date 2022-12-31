package com.suayipgurnaz.utility;

import com.suayipgurnaz.repository.entity.Departman;
import com.suayipgurnaz.repository.entity.Personel;

import java.util.*;

public class PtsUtility {
    public static List<Personel> personelList = new ArrayList<>();
    public static List<Departman> departmanList = new ArrayList<>();
    public static Map<Departman,List<Personel>> personelMap = new LinkedHashMap();

    static Scanner sc = new Scanner(System.in);

    public static String stringDegerAlma(String sorgu) {
        System.out.print(sorgu);
        return sc.nextLine();
    }
    public static double doubleDegerAlma(String sorgu) {
        System.out.print(sorgu);
        return Double.parseDouble(sc.nextLine());
    }
    public static int intDegerAlma(String sorgu) {
        System.out.print(sorgu);
        return Integer.parseInt(sc.nextLine());
    }
}
