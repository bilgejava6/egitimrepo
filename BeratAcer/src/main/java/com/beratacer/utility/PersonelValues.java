package com.beratacer.utility;

import com.beratacer.repository.entity.*;
import com.beratacer.service.DepartmanService;


import java.util.ArrayList;
import java.util.List;

import static com.beratacer.utility.StaticValues.stringScanner;
import static java.lang.Long.parseLong;

public class PersonelValues {

    public static GenelMudur genelMudur(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz : "));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        String uzmanlikAlani=stringScanner("Personel uzmanlik alani giriniz : ");
        return new GenelMudur(adSoyad, telNo, tcNo, adres, departman, isBasi, uzmanlikAlani);
    }
    public static Mudur mudur(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz : "));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        List<Departman> departmanList=addListMudur(departmanService);

        return new Mudur(adSoyad,telNo,tcNo,adres,departman,isBasi,departmanList);

    }
    public static InsanKaynaklariPersoneli insanKaynaklari(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz"));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        String iletisimBecerisi=stringScanner("Personel iletisim beceri seviyesini giriniz : ");
        return new InsanKaynaklariPersoneli(adSoyad,telNo,tcNo,adres,departman,isBasi,iletisimBecerisi);
    }
    public static BuroPersoneli buroPersoneli(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz"));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        String excelBilgisi=stringScanner("Personel bilgi seviyesini giriniz : ");
        return new BuroPersoneli(adSoyad,telNo,tcNo,adres,departman,isBasi,excelBilgisi);
    }
    public static Hizmetli hizmetli(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz"));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        String sorumlulukAlani=stringScanner("Personel sorumluluk alanini giriniz : ");
        return new Hizmetli(adSoyad,telNo,tcNo,adres,departman,isBasi,sorumlulukAlani);
    }
    public static MuhasebePersoneli muhasebe(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz"));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        String programlama=stringScanner("Personel program bilgisini giriniz : ");
        return new MuhasebePersoneli(adSoyad,telNo,tcNo,adres,departman,isBasi,programlama);
    }
    public static TeknikPersonel teknikPersonel(DepartmanService departmanService){
        String adSoyad=stringScanner("Personel ad soyad giriniz : ");
        String telNo=stringScanner("Personel telNo giriniz : ");
        String tcNo=stringScanner("Personel tcNo giriniz : ");
        String adres=stringScanner("Personel adres giriniz : ");
        Departman departman=departmanService.findByName(stringScanner("Personel departman giriniz"));
        String isBasi=stringScanner("Personel is baslangic tarihi giriniz : ");
        String sorumlulukAlani=stringScanner("Personel sorumluluk alanini giriniz : ");
        String teknikOzellik= stringScanner("Personel teknik ozellik giriniz : ");
        return new TeknikPersonel(adSoyad,telNo,tcNo,adres,departman,isBasi,sorumlulukAlani,teknikOzellik);
    }
    public static List<Departman> addListMudur(DepartmanService departmanService){
        List<Departman> departmanList=new ArrayList<>();
        Long secim=0l;
        do{
            Departman departman=departmanService.findByName(stringScanner("Sorumluluk departmani giriniz : "));
            departmanList.add(departman);
            secim=parseLong(stringScanner("Departman eklemeye devam etmek icin 1 e islemi sonlandırmak icin 0 a basınız : "));
        }while(secim!=0);
        return departmanList;
    }
    public static boolean isBlank(Personel personel){
        if (personel.getAdSoyad().isBlank()||
                personel.getTelNo().isBlank()||
                personel.getTcNo().isBlank()||
                personel.getAdres().isBlank()||
                personel.getIseBaslamaTarihi().isBlank()){
            return false;
        }else{
            return true;
        }
    }

}
