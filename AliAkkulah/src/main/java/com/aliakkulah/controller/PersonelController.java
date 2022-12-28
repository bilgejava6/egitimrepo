package com.aliakkulah.controller;

import com.aliakkulah.entity.*;
import com.aliakkulah.service.PersonelService;
import static com.aliakkulah.utility.Utility.*;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PersonelController {
    private final PersonelService ps;
    private static Scanner sc;

    public PersonelController() {
        this.ps = new PersonelService();
    }

    public void runAna() {
        sc = new Scanner(System.in);
        int secim = 0;
        int secim2 = 0;
        do {
            PersonelController pc = new PersonelController();
            System.out.println("*******   ANA MENU   *******");
            System.out.println("1. Personel Islemleri");
            System.out.println("2. Muhasebe Islemleri");
            System.out.println("3- Raporlamalar");
            System.out.println("0- CIKIS");
            System.out.println("Secim yapiniz.");
            secim = sc.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("*******   Personel Islemleri   *******");
                    System.out.println("1. Personel Ekleme");
                    System.out.println("2. Personel Listesi");
                    System.out.println("3. Personel Duzenleme");
                    System.out.println("4. Departman Ekleme");
                    System.out.println("5. Departman Listesi");
                    System.out.println("0. Ana Menuye Don");
                    System.out.println("Secim yapiniz.");
                    secim2 = sc.nextInt();
                    switch (secim2){
                        case 1:
                            System.out.println("1. Buro Personeli");
                            System.out.println("2. Genel Mudur");
                            System.out.println("3. Hizmetli");
                            System.out.println("4. Insan Kayanklari");
                            System.out.println("5. Mudur");
                            System.out.println("6. Muhasebe");
                            System.out.println("7. Teknik");
                            System.out.println("Eklemek istediginiz personel tipini seciniz");
                            eklenecekPersonelTipiSecme(sc.nextInt());
                            break;

                        case 2:
                            findAll();
                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5: break;
                        case 0: break;
                        default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                            break;
                    }   break;
                case 2:
                    System.out.println("*******   Muhasebe Islemleri   *******");
                    System.out.println("1 Maas Personel Tanimlama");
                    System.out.println("2 Odeme Listesi");
                    System.out.println("0. Ana Menuye Don");
                    System.out.println("Secim yapiniz.");
                    secim2 = sc.nextInt();
                    switch (secim2){
                        case 1: break;
                        case 2: break;
                        case 0: break;
                        default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                            break;
                    }   break;
                case 3:
                    System.out.println("*******   Raporlamalar   *******");
                    System.out.println("1 Departman Personel Listesi");
                    System.out.println("2 En Cok Personel Bulunan Departman");
                    System.out.println("3 Departmanlara Gore Maas Ortalamalari");
                    System.out.println("4 Mudurlerin Sorumlu Oldugu Departman Listesi");
                    System.out.println("5 Kayit Tarihlerine Gore Personellerin Sirali Listesi");
                    System.out.println("6 Ayni Gun Icinde Ise Baslayan Personellerin Listesi");
                    System.out.println("0. Ana Menuye Don");
                    System.out.println("Secim yapiniz.");
                    secim2 = sc.nextInt();
                    switch (secim2){
                        case 1: break;
                        case 2: break;
                        case 3: break;
                        case 4: break;
                        case 5: break;
                        case 6: break;
                        case 0: break;
                        default: System.out.println("Lutfen gecerli secim yapiniz.\nAna menuye donuldu.");
                            break;
                    }   break;
                case 0:
                    secim = 0;
                    break;
                default:
                    break;
            }
        }while(secim!=0);
    }

    public void eklenecekPersonelTipiSecme(int personelTipi) {
        switch (personelTipi) {
            case 1:
                buroEkle(ortakOzellikleriAl());
                break;
            case 2:
                genelMudurEkle(ortakOzellikleriAl());
                break;
            case 3:
                hizmetliEkle(ortakOzellikleriAl());
                break;
            case 4:
                ikEkle(ortakOzellikleriAl());
                break;
            case 5:
                mudurEkle(ortakOzellikleriAl());
                break;
            case 6:
                muhasebeEkle(ortakOzellikleriAl());
                break;
            case 7:
                teknikEkle(ortakOzellikleriAl());
                break;

            default:System.out.println("Yanlis secim yaptiniz.");
                break;
        }
    }
    public Stack<String> ortakOzellikleriAl() {
        sc = new Scanner(System.in);
        Stack<String> ortakOzellikler = new Stack<>();
        System.out.println("Maas giriniz.");
        ortakOzellikler.add(sc.nextLine());
        System.out.println("Cinsiyet giriniz.");
        ortakOzellikler.add(sc.nextLine());
        System.out.println("Dogum yili giriniz.");
        ortakOzellikler.add(sc.nextLine());
        System.out.println("İse giris tarihi giriniz. GG.AA.YYYY");
        ortakOzellikler.add(sc.nextLine());
        System.out.println("Personel unvanini giriniz.");
        ortakOzellikler.add(sc.nextLine());
        System.out.println("Personel soyadi giriniz.");
        ortakOzellikler.add(sc.nextLine());
        System.out.println("Personel adi giriniz.");
        ortakOzellikler.add(sc.nextLine());
        return ortakOzellikler;
    }
    public void buroEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        int dosyalamaHizi = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Buro"))
                depIndex = i;
        }
        Personel buroPersoneli = new BuroPersoneli(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                dosyalamaHizi);
        ps.save(buroPersoneli);
    }
    public void genelMudurEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        int bonusZamOrani = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Genel Mudur"))
                depIndex = i;
        }
        Personel genelMudur = new GenelMudur(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                bonusZamOrani);
        ps.save(genelMudur);
    }
    public void hizmetliEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        int temizlikDerecesi = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Hizmetli")) {
                depIndex = i;
                break;
            }
        }
        Personel hizmetli = new Hizmetli(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                temizlikDerecesi);
        ps.save(hizmetli);
    }
    public void ikEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        int iletisimKurmnaDerecesi = Integer.parseInt(sc.nextLine());
        int iseAlimSayisi = Integer.parseInt(sc.nextLine());
        int istenCikarmaSayisi = Integer.parseInt(sc.nextLine());
        int girdigiMulakatSayisi = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Insan Kaynaklari"))
                depIndex = i;
        }
        Personel ik = new IKPersoneli(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                iletisimKurmnaDerecesi,
                iseAlimSayisi,
                istenCikarmaSayisi,
                girdigiMulakatSayisi);
        ps.save(ik);
    }
    public void mudurEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        int bonusZamMiktari = Integer.parseInt(sc.nextLine());
        List<Personel> sorumluOlduguCalisanlar = null;
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Mudur"))
                depIndex = i;
        }
        Personel mudur = new Mudur(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                bonusZamMiktari,
                sorumluOlduguCalisanlar);
        ps.save(mudur);
    }
    public void muhasebeEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        double yatirdigiMaasMiktari = Double.parseDouble(sc.nextLine());
        int yatirdigiMaasAdeti = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Muhasebe"))
                depIndex = i;
        }
        Personel muhasebe = new MuhasebePersoneli(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                yatirdigiMaasMiktari,
                yatirdigiMaasAdeti);
        ps.save(muhasebe);
    }
    public void teknikEkle(Stack<String> ortakOzellikler) {
        sc = new Scanner(System.in);
        boolean meslekYeterlilikBelgesiVarMi;
        System.out.println("Mesleki yeterlilik belgesi var mi?");
        System.out.println("1. Var");
        System.out.println("2. Yok");
        System.out.println("Secim yapiniz.");
        int secim = Integer.parseInt(sc.nextLine());
        if(secim==1)
            meslekYeterlilikBelgesiVarMi = true;
        else if(secim == 0)
            meslekYeterlilikBelgesiVarMi = false;
        else {
            meslekYeterlilikBelgesiVarMi = false;
            System.out.println("Yanlis deger girildi.\nOtomatik olarak mesleki yeterlilik belgesi yok olarak kaydedildi.");
        }
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Teknik"))
                depIndex = i;
        }
        Personel teknik = new TeknikPersonel(ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                ortakOzellikler.pop(),
                Integer.parseInt(ortakOzellikler.pop()),
                ortakOzellikler.pop(),
                Double.parseDouble(ortakOzellikler.pop()),
                depIndex,
                meslekYeterlilikBelgesiVarMi);
        ps.save(teknik);
    }

    public void baslangicKisileriAtama() {
        Departman dp1 = new Departman("Buro");
        departmanListesi.add(dp1);
        Departman dp2 = new Departman("Genel Mudur");
        departmanListesi.add(dp2);
        Departman dp3 = new Departman("Hizmetli");
        departmanListesi.add(dp3);
        Departman dp4 = new Departman("Insan Kaynaklari");
        departmanListesi.add(dp4);
        Departman dp5 = new Departman("Mudur");
        departmanListesi.add(dp5);
        Departman dp6 = new Departman("Muhasebe");
        departmanListesi.add(dp6);
        Departman dp7 = new Departman("Teknik");
        departmanListesi.add(dp7);


        Personel bp1 = new BuroPersoneli("Umit","Gelecek","Yeni","09.01.2022",
                2000,"Erkek",10_000,0,3);
        Personel gm1 = new GenelMudur("Ozgur","Erturk","Genel Mudur","08.02.2007",
                1988,"Erkek",63_500,1,15);
        Personel hzmt1 = new Hizmetli("Selda","Dogru","Kidemli","22.11.2001",
                1985,"Kadin",11_500,2,5);
        Personel ik1 = new IKPersoneli("Yeliz","Serin","Kidemli","22.11.2001",
                1990,"Kadin",22_500,3,32,18,3,83);
        Personel mudur1 = new Mudur("Murat","Ozben","Mudur","11.08.2010",
                1985,"Erkek",47_880,4,1250,null);
        Personel mhsb1 = new MuhasebePersoneli("Fazli","Gunes","Yeni","20.10.2021",
                1993,"Erkek",13_750,5,1_253_532,90);
        Personel tp1 = new TeknikPersonel("Muammer","Karatas","Kidemli","08.02.2007",
                1991,"Erkek",19_500,6,false);
        Personel bp2 = new BuroPersoneli("Ahmet","Kocaman","Kidemli","09.07.2014",
                1985,"Erkek",16_000,0,3);
        Personel hzmt2 = new Hizmetli("Buse","Yildiz","Yeni","20.10.2021",
                2001,"Kadin",8_500,2,3);
        Personel ik2 = new IKPersoneli("Aynur","Sulak","Yeni","20.07.2019",
                1972,"Kadin",33_500,3,3,5,3,30);
        Personel mudur2 = new Mudur("Umut","Saygin","Kidemli","09.07.2014",
                1970,"Erkek",29_880,4,1250,null);
        Personel mhsb2 = new MuhasebePersoneli("Ufuk","Yilmaz","Kidemli","08.02.2007",
                1980,"Erkek",29_770,5,3_845_552,445);
        Personel tp2 = new TeknikPersonel("Samet","Demirer","Yeni","05.10.2018",
                1999,"Erkek",11_500,6,false);
        personelListesi.add(bp1);
        personelListesi.add(bp2);
        personelListesi.add(gm1);
        personelListesi.add(hzmt1);
        personelListesi.add(hzmt2);
        personelListesi.add(ik1);
        personelListesi.add(ik2);
        personelListesi.add(mudur1);
        personelListesi.add(mudur2);
        personelListesi.add(mhsb1);
        personelListesi.add(mhsb2);
        personelListesi.add(tp1);
        personelListesi.add(tp2);
    }

    public void guncellenecekPersonelSecme() {

    }
    public void update(Personel personel){

        ps.update(personel);
    }
    public void deleteById(){
        ps.deleteById(null);
    }
    public void delete(Long id){
        ps.delete(null);
    }
    public void findAll(){
        ps.findAll().forEach(System.out::println);
    }
    public Personel findById(Long id){
        return ps.findById(id);
    }
}