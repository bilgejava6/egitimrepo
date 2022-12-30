package com.aliulas.utility;

import com.aliulas.repository.entity.Departman;
import com.aliulas.repository.entity.Personel;

import java.util.*;

public class StaticValues {
    public static Long id = 0L;

    public static Map<Long, Departman> departmanListesi = new HashMap<Long, Departman>();

    public static long idOlustur() {
        ++id;
        return id;
    }
    public static List<Personel> personelListesi = new ArrayList<>();
}
