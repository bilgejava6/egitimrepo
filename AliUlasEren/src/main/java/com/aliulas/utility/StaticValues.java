package com.aliulas.utility;

import com.aliulas.repository.entity.Departman;
import com.aliulas.repository.entity.Personel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StaticValues {
    public static Long id = 0L;
    public static List<Personel> personelListesi = new ArrayList<>();
    public static Set<Departman> departmanListesi = new HashSet<>();

    public static long idOlustur() {
        ++id;
        return id;
    }
}
