package com.yavuzavci.utility;

import com.yavuzavci.controller.DepartmanController;
import com.yavuzavci.controller.PersonelController;
import com.yavuzavci.entity.*;
import com.yavuzavci.utility.menu.AnaMenu;
import com.yavuzavci.utility.menu.MuhasebeMenu;
import com.yavuzavci.utility.menu.PersonelMenu;
import com.yavuzavci.utility.menu.RaporlamaMenu;

import java.util.*;

import static com.yavuzavci.entity.ECinsiyet.*;

/**
 * Uygulama başlangıcında ve sonrasında kullanılacak verilerin tutulduğu
 * işlevsel sınıf.
 * @author Yavuz AVCI
 */
public class StaticValues {
    // Sabitler
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final DepartmanController DEPARTMAN_CONTROLLER = new DepartmanController();
    public static final PersonelController PERSONEL_CONTROLLER = new PersonelController();
    public static final AnaMenu ANA_MENU = new AnaMenu();
    public static final MuhasebeMenu MUHASEBE_MENU = new MuhasebeMenu();
    public static final PersonelMenu PERSONEL_MENU = new PersonelMenu();
    public static final RaporlamaMenu RAPORLAMA_MENU = new RaporlamaMenu();
    public static final List<Personel> PERSONEL_LISTESI = new ArrayList<>();
    public static final Map<Long, Departman> DEPARTMAN_LISTESI = new TreeMap<>();
    // Değişkenler
    private static Long personelId = 0L;
    private static Long departmanId = 0L;
    // Methodlar

    /**
     * Uygulama buradan başlar.
     */
    public static void run(){
        init();
        ANA_MENU.menu();
    }

    /**
     * Başlangıçta gerekli olan değerler burada atanır.
     */
    public static void init(){
        // Sistem departmanları, burayı silmeyin.
        Departman aktifOlmayanPersonel = new Departman("Aktif Olmayan Personel");
        aktifOlmayanPersonel.setId(-2L);
        DEPARTMAN_LISTESI.put(aktifOlmayanPersonel.getId(),aktifOlmayanPersonel);

        Departman yok = new Departman("Yok");
        yok.setId(-1L);
        DEPARTMAN_LISTESI.put(yok.getId(),yok);

        Departman mudurler = new Departman("Müdürler");
        mudurler.setId(0L);
        DEPARTMAN_LISTESI.put(mudurler.getId(),mudurler);

        // Varsayılan departmanlardan önce ID sayacını sıfırla.
        departmanId = 0L;

        // Varsayılan personel departmanları
        Departman departman = new Departman("Hizmetliler");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        departman = new Departman("İnsan Kaynakları");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        departman = new Departman("Muhasebe");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        departman = new Departman("Satış");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        departman = new Departman("İhracat");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        departman = new Departman("Depo");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        departman = new Departman("Üretim");
        DEPARTMAN_LISTESI.put(departman.getId(),departman);
        // Personel Test Verisi
        GenelMudur gm = new GenelMudur("Ali YILMAZ", ERKEK,57,"09008009999",mudurler
        ,80000.0,true,true,true);
        gm.setDepartmanlar(DEPARTMAN_LISTESI.values().stream().toList());
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(gm);
        PERSONEL_LISTESI.add(gm);

        Mudur mudur = new Mudur("Mehmet YILDIRIM",ERKEK,40,"09008009999",
                departmanBul(1L),35000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(1L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);

        mudur = new Mudur("Abdullah BOZOK",ERKEK,48,"09008009999",
                departmanBul(2L),50000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(2L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);

        mudur = new Mudur("Damla BAYINDIR",KADIN,39,"09008009999",
                departmanBul(3L),50000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(3L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);

        mudur = new Mudur("Özge ÇETİN",KADIN,43,"09008009999",
                departmanBul(4L),60000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(4L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);

        mudur = new Mudur("Ece SARIKAYA",KADIN,40,"09008009999",
                departmanBul(5L),65000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(5L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);

        mudur = new Mudur("Osman DEMİRCİ",ERKEK,50,"09008009999",
                departmanBul(6L),60000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(6L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);

        mudur = new Mudur("Cengiz ÖZTÜRK",ERKEK,45,"09008009999",
                departmanBul(7L),50000.0,true,true);
        DEPARTMAN_LISTESI.get(0L).getPersonelListesi().add(mudur);
        DEPARTMAN_LISTESI.get(7L).getPersonelListesi().add(mudur);
        PERSONEL_LISTESI.add(mudur);
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

    /**
     * Uygulama başlarken kullanılan departman bulma methodu.
     * @param id Departman Numarası
     * @return {@code Departman} döner. Bulamadığı yerde {@code null} döner.
     */
    private static Departman departmanBul(Long id){
        for(Departman departman : DEPARTMAN_LISTESI.values()){
            if(departman.getId().equals(id))
                return departman;
        }
        return null;
    }
}
