package com.emreustun.utility;

import com.emreustun.entity.Departman;
import com.emreustun.entity.GenelMudur;
import com.emreustun.entity.Mudur;
import com.emreustun.entity.Personel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticValues {
    public static Long id = 0L;
    public static List<Personel> personelListesi = new ArrayList<>();
    public static List<Departman> departmanListesi = new ArrayList<>();
    public static Map<Mudur,List<Departman>> mapMudurDepartmanListesi = new HashMap<>();
    public static Map<GenelMudur,List<Departman>> mapGenelMudurDepartmanListesi = new HashMap<>();
   // public static Map<Departman,List<Personel>> departmanlaraGorePersonelListesi = new HashMap<>();

    public static long idOlustur() {
        ++id;
        return id;
    }
}
