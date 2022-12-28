package com.aliakkulah.utility;

import java.util.*;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.entity.Personel;


public class Utility {
    static Long id = 0l;
    static Long depId = 0l;

    public static Long idOlustur() {
        id++;
        return id;
    }

    public static Long depIdOlustur() {
        depId++;
        return depId;
    }
    public static List<Personel> personelListesi = new ArrayList();
    public static List<Departman> departmanListesi = new ArrayList<>();
}