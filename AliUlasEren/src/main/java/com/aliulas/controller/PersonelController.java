package com.aliulas.controller;
import com.aliulas.repository.entity.BuroPersoneli;
import com.aliulas.repository.entity.GenelMudur;
import com.aliulas.repository.entity.Personel;
import com.aliulas.service.PersonelService;

import java.util.*;

public class PersonelController {
        private final PersonelService personelService;
        private static Scanner sc;

        public PersonelController(){
            personelService = new PersonelService();
        }
    public void anaMenu(){
            int secim = 0;
            do{
                System.out.println("************************************************************");
                System.out.println("************** PERSONEL TAKİP SİSTEMİ ********************");
                System.out.println("************************************************************");
                System.out.println();
                System.out.println("1. Personel İşlemleri");
                System.out.println("2. Muhasebe İşlemleri");
                System.out.println("3. Raporlamalar");
                System.out.println("4. Çıkış");
                System.out.println();
                System.out.print("Seçiminiz: ");
                secim = sc.nextInt();
                switch (secim){
                    case 1:
                        personelIslemleriMenu();
                        break;
                    case 2:
                        //muhasebeIslemleriMenu();
                        break;
                    case 3:
                        //raporlamalarMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                        anaMenu();
                        break;
                }


            }while(secim!=0);
    }
    public void personelIslemleriMenu() {
            int secim = 0;
            do{
                System.out.println("1. Personel Ekleme");
                System.out.println("2. Personel Listesi");
                System.out.println("3. Personel Düzenleme");
                System.out.println("4. Departman Ekleme");
                System.out.println("5. Departman Listesi");
                System.out.println("6. Ana Menü");
                System.out.println();
                System.out.print("Seçiminiz: ");

                 sc = new Scanner(System.in);
                secim = sc.nextInt();

                switch (secim) {
                    case 1:
                        personelEkleme();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        // Departman listesi işlemleri
                        break;
                    case 6:
                        anaMenu();
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                        personelIslemleriMenu();
                        break;
                }
            }while(secim!=0);

    }
    public void personelEkleme(){
            int secim=0;
            do {
                System.out.println("1. Buro Personeli");
                System.out.println("2. Genel Mudur");
                System.out.println("3. Hizmetli");
                System.out.println("4. Insan Kaynaklari");
                System.out.println("5. Mudur");
                System.out.println("6. Muhasebe Personeli");
                System.out.println("7. Teknik Personel");
                System.out.println("Eklemek istediginiz personel tipini seciniz");
            }while(secim!=0);
    }



    public LinkedList<String> personelOzellik(){
        sc = new Scanner(System.in);
        LinkedList<String> personelOzellik = new LinkedList<>();
        System.out.println("Personel adi giriniz.");
        personelOzellik.add(sc.nextLine());
        System.out.println("Personel soyadi giriniz.");
        personelOzellik.add(sc.nextLine());
        System.out.println("Email giriniz.");
        personelOzellik.add(sc.nextLine());
        System.out.println("Telefon no giriniz");
        personelOzellik.add(sc.nextLine());
        System.out.println("Personel pozisyonu giriniz.");
        personelOzellik.add(sc.nextLine());
        System.out.println("Personel işe giriş tarihi giriniz.");
        personelOzellik.add(sc.nextLine());
        System.out.println("Personel maaşı giriniz.");
        personelOzellik.add(sc.nextLine());
        return personelOzellik;
    }
    public void buroPersoneli(){
            sc= new Scanner(System.in);
            String brim = sc.nextLine();
            Personel buroPersoneli = new BuroPersoneli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),personelOzellik().pop(),brim);
            personelService.save(buroPersoneli);

    }
    public void genelMudur(){
            sc = new Scanner(System.in);
            String sorumluOlduguAlanlar = sc.nextLine();
            Personel genelMudur = new GenelMudur(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),sorumluOlduguAlanlar);
            personelService.save(genelMudur);
    }
    public void hizmetli(){
            sc = new Scanner(System.in);
            String hizmetAlani = sc.nextLine();
            int calismaSaatleri = sc.nextInt();

    }



}
