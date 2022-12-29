package com.yavuzavci.utility;

import com.yavuzavci.controller.DepartmanController;
import com.yavuzavci.controller.PersonelController;
import com.yavuzavci.entity.Departman;
import com.yavuzavci.entity.Personel;
import com.yavuzavci.utility.menu.AnaMenu;
import com.yavuzavci.utility.menu.MuhasebeMenu;
import com.yavuzavci.utility.menu.PersonelMenu;
import com.yavuzavci.utility.menu.RaporlamaMenu;

import java.util.*;

public class StaticValues {
    // Sabitler
    public static final Scanner scanner = new Scanner(System.in);
    public static final DepartmanController departmanController = new DepartmanController();
    public static final PersonelController personelController = new PersonelController();
    public static final AnaMenu anaMenu = new AnaMenu();
    public static final MuhasebeMenu muhasebeMenu = new MuhasebeMenu();
    public static final PersonelMenu personelMenu = new PersonelMenu();
    public static final RaporlamaMenu raporlamaMenu = new RaporlamaMenu();
    public static final List<Personel> personelListesi = new ArrayList<>();
    public static final Map<Long, Departman> departmanListesi = new TreeMap<>();
    // Değişkenler
    public static Long personelId = 0L;
    public static Long departmanId = 0L;
    // Methodlar
    public static void run(){
        init();
        anaMenu.menu();
    }

    /**
     * Başlangıçta gerekli olan değerler burada atanır.
     */
    public static void init(){
        // özel amaçla eklenen departmanlar, burayı silmeyin.
        Departman aktifOlmayanPersonel = new Departman("Aktif Olmayan Personel");
        aktifOlmayanPersonel.setId(-2L);
        departmanListesi.put(aktifOlmayanPersonel.getId(),aktifOlmayanPersonel);
        Departman yok = new Departman("Yok");
        yok.setId(-1L);
        departmanListesi.put(yok.getId(),yok);
        Departman mudurler = new Departman("Müdürler");
        mudurler.setId(0L);
        departmanListesi.put(mudurler.getId(),mudurler);
        departmanId = 0L;
        // Varsayılan personel departmanları
        Departman departman = new Departman("Hizmetliler");
        departmanListesi.put(departman.getId(),departman);
        departman = new Departman("İnsan Kaynakları");
        departmanListesi.put(departman.getId(),departman);
        departman = new Departman("Muhasebe");
        departmanListesi.put(departman.getId(),departman);
        departman = new Departman("Satış");
        departmanListesi.put(departman.getId(),departman);
        departman = new Departman("İhracat");
        departmanListesi.put(departman.getId(),departman);
        departman = new Departman("Depo");
        departmanListesi.put(departman.getId(),departman);
        departman = new Departman("Üretim");
        departmanListesi.put(departman.getId(),departman);
    }
    public static long yeniPersonelIdAl(){
        return ++personelId;
    }
    public static long yeniDepartmanIdAl(){
        return ++departmanId;
    }

    public static long sistemSaatiniAl(){
        return System.currentTimeMillis();
    }
}
