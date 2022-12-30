package com.aliakkulah.controller;

import com.aliakkulah.entity.*;
import com.aliakkulah.service.PersonelService;
import static com.aliakkulah.utility.Utility.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PersonelController {
    private final PersonelService ps;
    private static Scanner sc;

    public PersonelController() {
        this.ps = new PersonelService();
    }
    public void odemeListesi(Personel yetkili) {
        sc = new Scanner(System.in);
        if(yetkili.getDepartman().getAd().equalsIgnoreCase("Muhasebe")){
            ps.odemeListesi().entrySet().forEach(System.out::println);
        }else
            System.out.println("Odeme listesini goruntuleme yetkiniz bulunmamaktadir.");
    }
    public void maasTanimla(Personel yetkili){
        sc = new Scanner(System.in);
        if(yetkili.getDepartman().getAd().equalsIgnoreCase("Muhasebe")){
            System.out.println("Maas tanimlanacak personel id sini giriniz.");
            Long id = Long.parseLong(sc.nextLine());
            System.out.println("Maasi giriniz.");
            int maas = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < personelListesi.size(); i++){
                if(personelListesi.get(i).getId().equals(id)){
                    System.out.print(personelListesi.get(i).getAd() + "'nin " + personelListesi.get(i).getMaas() + " Tl olan eski maasi ");
                    personelListesi.get(i).setMaas(maas);
                    System.out.println(maas + " Tl olarak guncellendi.");
                    break;
                }
            }
        }else
            System.out.println("Maas tanimlama yetkiniz bulunmamaktadir.");
    }
    public void guncellenecekPersonelSecme() {
        sc = new Scanner(System.in);
        System.out.println("Guncellenecek personel id'sini giriniz.");
        int guncellenecekId = Integer.parseInt(sc.nextLine());
        Personel guncellenecekPersonel = null;
        for(int i = 0; i < personelListesi.size(); i++){
            if(personelListesi.get(i).getId() == guncellenecekId){
                guncellenecekPersonel = personelListesi.get(i);
                break;
            }
        } if(!guncellenecekPersonel.equals(null)) {

        }else
            System.out.println("Girilen id'ye ait bir personel bulunmamaktadir. Guncelleme yapilamadi.");
    }
    public void deleteById(){
        sc = new Scanner(System.in);
        System.out.println("Silmek istediginiz personelin id'sini giriniz.");
        Long id = Long.parseLong(sc.nextLine());
        ps.deleteById(id);
    }
    public void delete(){
        sc = new Scanner(System.in);
        for(int i = 0; i < personelListesi.size(); i++){
            System.out.println((i+1) + ") " + personelListesi.get(i).getAd() + " " + personelListesi.get(i).getSoyad());
        }
        System.out.println("Silmek istediginiz personelin sira numarasini giriniz.");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        ps.delete(personelListesi.get(index));
    }
    public void findAll(){
        ps.findAll().forEach(System.out::println);
    }
    public void findById(){
        sc = new Scanner(System.in);
        System.out.println("Istediginiz personelin id'sini giriniz.");
        Long id = Long.parseLong(sc.nextLine());
        ps.findById(id);
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
        System.out.println("Dosyalama hizi giriniz.");
        int dosyalamaHizi = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Buro")) {
                depIndex = i;
                break;
            }
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
        System.out.println("Bonus zaqm orani giriniz.");
        int bonusZamOrani = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Genel Mudur")) {
                depIndex = i;
                break;
            }
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
        System.out.println("Temizlik derecesi giriniz.(0-5 arası)");
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
        System.out.println("Iletisim kurma derecesi giriniz.(0-5 arasi)");
        int iletisimKurmnaDerecesi = Integer.parseInt(sc.nextLine());
        System.out.println("Ise alim sayisi giriniz.");
        int iseAlimSayisi = Integer.parseInt(sc.nextLine());
        System.out.println("Isten cikarma sayisini giriniz.");
        int istenCikarmaSayisi = Integer.parseInt(sc.nextLine());
        System.out.println("Girdigi mulakat sayisini giriniz.");
        int girdigiMulakatSayisi = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Insan Kaynaklari")) {
                depIndex = i;
                break;
            }
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
        System.out.println("Bonus zam miktarini giriniz.");
        int bonusZamMiktari = Integer.parseInt(sc.nextLine());
        List<Personel> sorumluOlduguCalisanlar = null;
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Mudur")){
                depIndex = i;
                break;
            }
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
        System.out.println("Yatirdigi maas miktarini giriniz.");
        double yatirdigiMaasMiktari = Double.parseDouble(sc.nextLine());
        System.out.println("Yatirdigi maas adetini giriniz.");
        int yatirdigiMaasAdeti = Integer.parseInt(sc.nextLine());
        int depIndex = 0;
        for(int i = 0; i < departmanListesi.size(); i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Muhasebe")) {
                depIndex = i;
                break;
            }
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
            if(departmanListesi.get(i).getAd().equalsIgnoreCase("Teknik")) {
                depIndex = i;
                break;
            }
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
        Personel bp1 = new BuroPersoneli("Umit","Gelecek","Yeni","09.01.2022",
                2000,"Erkek",10_000,1,3);

        Personel gm1 = new GenelMudur("Ozgur","Erturk","Genel Mudur","08.02.2007",
                1988,"Erkek",63_500,2,15);
        Personel hzmt1 = new Hizmetli("Selda","Dogru","Kidemli","22.11.2001",
                1985,"Kadin",11_500,3,5);
        Personel ik1 = new IKPersoneli("Yeliz","Serin","Kidemli","22.11.2001",
                1990,"Kadin",22_500,4,32,18,3,83);
        Personel mudur1 = new Mudur("Murat","Ozben","Mudur","11.08.2010",
                1985,"Erkek",47_880,5,1250,null);
        Personel mhsb1 = new MuhasebePersoneli("Fazli","Gunes","Yeni","20.10.2021",
                1993,"Erkek",13_750,6,1_253_532,90);
        Personel tp1 = new TeknikPersonel("Muammer","Karatas","Kidemli","08.02.2007",
                1991,"Erkek",19_500,7,false);
        Personel bp2 = new BuroPersoneli("Ahmet","Kocaman","Kidemli","09.07.2014",
                1985,"Erkek",16_000,1,3);
        Personel hzmt2 = new Hizmetli("Buse","Yildiz","Yeni","20.10.2021",
                2001,"Kadin",8_500,3,3);
        Personel ik2 = new IKPersoneli("Aynur","Sulak","Yeni","20.07.2019",
                1972,"Kadin",33_500,4,3,5,3,30);
        Personel mudur2 = new Mudur("Umut","Saygin","Kidemli","09.07.2014",
                1970,"Erkek",29_880,5,1250,null);
        Personel mhsb2 = new MuhasebePersoneli("Ufuk","Yilmaz","Kidemli","08.02.2007",
                1980,"Erkek",29_770,6,3_845_552,445);
        Personel tp2 = new TeknikPersonel("Samet","Demirer","Yeni","05.10.2018",
                1999,"Erkek",11_500,7,false);
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
    public void siraliPersonelListesi() {ps.siraliPersonelListesi();}
    public void ayniGunBaslayanlarListesi() { ps.ayniGunBaslayanlarListesi();}
    public void mudureSorumluOlduguDepartmanEkle() {
        sc = new Scanner(System.in);
        List<Personel> mudurler = new ArrayList<>();
        for(Departman departman : departmanListesi){
            if(departman.getAd().equalsIgnoreCase("Mudur"))
                mudurler = departman.getPersonelList();
        }
        for(int i = 0; i < mudurler.size(); i++) {
            Mudur mudur = (Mudur) mudurler.get(i);
            System.out.println((i + 1) + ". Mudur: " + mudur.getAd() + " " + mudur.getSoyad() + "'nın departmanları:");
            mudur.getSorumluOlduguDepartmanlar().forEach(System.out::println);
        }
        System.out.println("Departman eklemek istediginiz mudurun sira numarasini giriniz.");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        for(int i = 0; i < departmanListesi.size(); i++){
            System.out.println((i+1) + ") " + departmanListesi.get(i));
        }
        System.out.println("Eklemek istediginiz departmanin sira numarasini giriniz.");
        int index2 = Integer.parseInt(sc.nextLine()) - 1;
        ps.mudureSorumluOlduguDepartmanEkle((Mudur) mudurler.get(index), departmanListesi.get(index2));
    }

    public void mudurlerinSorumluOlduguDepartmanlar() {ps.mudurlerinSorumluOlduguDepartmanlar();}
}