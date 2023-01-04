package com.AraDonemOdevi.Utility;

import com.AraDonemOdevi.Entity.Departman;
import com.AraDonemOdevi.Entity.Personel;


import java.util.HashMap;

import java.util.Map;

public class PersonelUtility {

    static Long id=0L;


    public static Map<Long,Personel> personelListesi = new HashMap<Long,Personel>();
    public static long idOlustur() {
        id++;
        return id;
    }

}
