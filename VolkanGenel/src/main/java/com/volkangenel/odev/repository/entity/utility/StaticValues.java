package com.volkangenel.odev.repository.entity.utility;

import com.volkangenel.odev.repository.entity.Departman;
import com.volkangenel.odev.repository.entity.Personel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StaticValues {
    public static Long id = 0L;
    public static Long departmanid = 0L;
    public static List<Personel> personelListesi = new ArrayList<>();
    public static List<Departman> departmanListesi = new ArrayList<Departman>();

    public static Map<Departman, List<Personel>> gruplanmisListem = new TreeMap<>();
    public static long idOlustur() {
        id++;
        return id;
    }
    public static long departmanidOlustur() {
        departmanid++;
        return departmanid;
    }
}
