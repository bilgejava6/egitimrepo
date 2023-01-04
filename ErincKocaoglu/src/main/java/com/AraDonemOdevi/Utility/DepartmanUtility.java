package com.AraDonemOdevi.Utility;

import com.AraDonemOdevi.Entity.Departman;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DepartmanUtility {

    static Long count=0L;


    public static List<Departman> departmanListesi = new ArrayList<>();

    public static long sayac() {
        count++;
        return count;
    }
}
