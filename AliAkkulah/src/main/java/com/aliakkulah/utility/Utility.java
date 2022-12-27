package com.aliakkulah.utility;

import java.util.ArrayList;
import java.util.List;

import com.aliakkulah.entity.Personel;


public class Utility {
    static Long id = 0l;

    public static Long idOlustur() {
        id++;
        return id;
    }

    public static List<Personel> personelListesi = new ArrayList();
}