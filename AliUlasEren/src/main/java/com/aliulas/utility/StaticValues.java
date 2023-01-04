package com.aliulas.utility;

import com.aliulas.repository.entity.Departman;
import com.aliulas.repository.entity.Personel;

import java.util.*;

public class StaticValues {
    public static int id = 0;

    public static List<Departman> departmanListesi = new ArrayList<>();

    public static int idOlustur() {
        ++id;
        return id;
    }
    public static List<Personel> personelListesi = new ArrayList<>();
}
