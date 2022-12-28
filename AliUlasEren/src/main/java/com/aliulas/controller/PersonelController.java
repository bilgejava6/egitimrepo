package com.aliulas.controller;
import com.aliulas.repository.entity.*;
import com.aliulas.service.PersonelService;
import static com.aliulas.utility.StaticValues.*;

import java.util.*;

public class PersonelController {
        private final PersonelService personelService;
        private static Scanner sc;

        public PersonelController(){
            personelService = new PersonelService();
        }


    public void update(Personel personel){
        personelService.update(personel);
    }

    public void delete(Long id){
        personelService.delete(null);
    }
    public void findAll(){
            List<Personel> personelListesi = personelService.findAll();
            for (Personel personel : personelListesi) {
                System.out.println(personel);
            }
        }

    public Personel findById(Long id){
        return personelService.findById(id);
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
                        findAll();
                        break;
                    case 3:
                        System.out.print("Düzenlenecek personelin id'sini giriniz: ");
                        long id = sc.nextLong();
                        Personel personel = personelService.findById(id);
                        if (personel == null) {
                            System.out.println("Bu id'ye sahip personel bulunamadı!");
                            return;
                        }

                        System.out.print("Yeni adı girin: ");
                        String ad = sc.nextLine();
                        personel.setAd(ad);
                        System.out.print("Yeni soyadı girin: ");
                        String soyad = sc.nextLine();
                        personel.setSoyad(soyad);
                        System.out.println("Yeni emaili girin: ");
                        String email  = sc.nextLine();
                        personel.setEmail(email);
                        System.out.println("Yeni telefon numarasını girin: ");
                        String telefon = sc.nextLine();
                        personel.setTelefon(telefon);
                        System.out.print("Yeni maaşı girin: ");
                        int maas = sc.nextInt();
                        personel.setMaas(maas);
                        System.out.print("Yeni işe giriş tarihini girin (gg.aa.yyyy formatında): ");
                        String iseGirisTarihiStr = sc.nextLine();
                        personel.setKayitTarihi(iseGirisTarihiStr);

                        personelService.update(personel);
                        System.out.println("Personel başarıyla güncellendi.");
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
                switch (secim) {
                    case 1:
                        buroPersoneli(personelOzellik());
                        break;
                    case 2:
                        genelMudur(personelOzellik());
                        break;
                    case 3:
                        hizmetli(personelOzellik());
                        break;
                    case 4:
                        insanKaynaklari(personelOzellik());
                        break;
                    case 5:
                        mudur(personelOzellik());
                        break;
                    case 6:
                        muhasebe(personelOzellik());
                        break;
                    case 7:
                        teknik(personelOzellik());
                        break;

                    default:System.out.println("Yanlis secim yaptiniz.");
                        break;
                }
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
    public void buroPersoneli(LinkedList<String> strings){
            sc= new Scanner(System.in);
            String brim = sc.nextLine();
            Personel buroPersoneli = new BuroPersoneli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),personelOzellik().pop(),brim);
            personelService.save(buroPersoneli);

    }
    public void genelMudur(LinkedList<String> strings){
            sc = new Scanner(System.in);
            String sorumluOlduguDepartmanlar = sc.nextLine();
            Personel genelMudur = new GenelMudur(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),sorumluOlduguDepartmanlar);
            personelService.save(genelMudur);
    }
    public void hizmetli(LinkedList<String> strings){
            sc = new Scanner(System.in);
            String hizmetAlani = sc.nextLine();
            int calismaSaatleri = sc.nextInt();
            Personel hizmetli = new Hizmetli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),hizmetAlani,calismaSaatleri);

    }
    public void insanKaynaklari(LinkedList<String> strings){
            sc = new Scanner(System.in);
            String calismaAlani = sc.nextLine();
            Personel insanKaynaklari = new InsanKaynaklariPersoneli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),calismaAlani);
            personelService.save(insanKaynaklari);
    }
    public void mudur(LinkedList<String> strings){
            sc = new Scanner(System.in);
            String sorumluOlduguDepartman = sc.nextLine();
            Personel mudur = new Mudur(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),sorumluOlduguDepartman);
            personelService.save(mudur);
    }

    public void muhasebe(LinkedList<String> strings){
            sc = new Scanner(System.in);
            double maasEkle = sc.nextDouble();
            Personel muhasebe = new MuhasebePersoneli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),maasEkle);
            personelService.save(muhasebe);
    }
    public void teknik(LinkedList<String> strings){
            sc = new Scanner(System.in);
            String bilgiSeviyesi = sc.nextLine();
            Personel teknik = new TeknikPersonel(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),bilgiSeviyesi);
            personelService.save(teknik);
    }
    public void baslangicListesi(){
            Personel buroPersonel = new BuroPersoneli("Zeynep","Sev","zeynepsev@gmail.com","053423421345",
                    "Büro Müdürü",8500
                    ,"20.10.1997","Büro");
            Personel genelMudur = new GenelMudur("Serap","Gül","serapGul@gmail.com",
                    "0532 231 45 42","Genel Müdür",17700,"10.10.2020","Tüm Departmanlar");
            Personel hizmetli = new Hizmetli("Tekin","Tekindor","tekintekindor@gmail.com","0534 543 21 42","hizmetli",8500,
                  "13.04.2019","muhasebe,teknik", 10 );
            Personel insanKaynaklari = new InsanKaynaklariPersoneli("Gülin","Serin","gulinserin@gmail.com","0554 231 31 56","insan kaynaklari müdürü",
                    10000,"07.02.2015","müdürlükler hariç tüm birimler");
            Personel mudur = new Mudur("Serhat","Tekin","serhattekin@gmail.com","0555 532 21 21","müdür",
                    14000,"06.02.2021","Teknik");
            Personel muhasebePersoneli = new MuhasebePersoneli("Cengiz","Taş","cengiztas@gmail.com","0531 523 40 21","personel",
                    10000,"05.10.2005",2131_213D);
            personelListesi.add(buroPersonel);
            personelListesi.add(genelMudur);
            personelListesi.add(hizmetli);
            personelListesi.add(insanKaynaklari);
            personelListesi.add(mudur);
            personelListesi.add(muhasebePersoneli);

                    
    }






}
