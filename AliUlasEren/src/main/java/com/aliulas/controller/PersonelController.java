package com.aliulas.controller;
import com.aliulas.repository.entity.*;
import com.aliulas.service.PersonelService;
import static com.aliulas.utility.StaticValues.*;

import java.util.*;

public class PersonelController {
    private static Scanner sc = new Scanner(System.in);
    PersonelService ps;
    DepartmanController dc = new DepartmanController();
    String secim2;
    public PersonelController() {
        this.ps = new PersonelService();
    }

    public void update(Personel personel){
        ps.update(personel);
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
    public void anaMenu(){

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
        int secim = sc.nextInt();
        switch (secim){
            case 1:
                personelIslemleriMenu();
                break;
            case 2:
                muhasebeIslemleriMenu();
                break;
            case 3:
                raporlamalarMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Geçersiz seçim!");
                anaMenu();
                break;
        }

    }

    private void muhasebeIslemleriMenu() {
        System.out.println("1. Maaş Personel Tanımlama");
        System.out.println("2. Ödeme Listesi");
    }

    private void raporlamalarMenu() {
        System.out.println("1. Departman Personel Listesi");
        System.out.println("2. En Çok Personel Bulunan Departman");
        System.out.println("3. Departmanlara Göre Maaş Ortalamaları");
        System.out.println("4. Müdürlerin Sorumlu Olduğu Departman Listesi");
        System.out.println("5. Kayıt Tarihlerine Göre Personellerin Sıralı Listesi");
        System.out.println("6. Aynı Gün İçinde İşe Başlayan Personellerin Listesi");
        System.out.println();
        System.out.print("Seçiminiz: ");
        sc = new Scanner(System.in);
        int raporSecim = sc.nextInt();
        switch (raporSecim) {
            case 1:
                System.out.println("Lütfen departman adı girin:");
                sc = new Scanner(System.in);
                String departmanAdi = sc.nextLine();
                dc.departmanPersonelListesi(departmanAdi);
                anaMenu();
            case 2:
                dc.enCokPersonelBulunanDepertman();
                anaMenu();
            case 3:
                dc.departmanlaraGoreMaasOrtalamasi();
                anaMenu();
            case 4:
                dc.mudurSorumlu();
                anaMenu();
        }
    }

    public void personelIslemleriMenu() {
        System.out.println("1. Personel Ekleme");
        System.out.println("2. Personel Listesi");
        System.out.println("3. Personel Düzenleme");
        System.out.println("4. Departman Ekleme");
        System.out.println("5. Departman Listesi");
        System.out.println("6. Ana Menü");
        System.out.println();
        System.out.print("Seçiminiz: ");

        sc = new Scanner(System.in);
        int secim = sc.nextInt();

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
                Personel personel = ps.findById(id);
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
                String email = sc.nextLine();
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
                ps.update(personel);
                System.out.println("Personel başarıyla güncellendi.");
                break;
            case 4:
                dc.save();
                anaMenu();
                break;
            case 5:
                System.out.println(dc.findAll().stream().toList());
                System.out.println(departmanListesi.size());
                break;
            case 6:
                anaMenu();
                break;
            default:
                System.out.println("Geçersiz seçim!");
                personelIslemleriMenu();
                break;
        }

    }

    public void personelEkleme(){

        System.out.println("Personeli eklemek istediğiniz departmanın adını yazınız");
        sc = new Scanner(System.in);
        secim2 = sc.nextLine();
            if (secim2.equals("Buro")) buroPersoneli(personelOzellik());
            else if (secim2.equals("Genel Mudur")) genelMudur(personelOzellik());
            else if (secim2.equals("Hizmetli"))  hizmetli(personelOzellik());
            else if (secim2.equals("İnsan Kaynakları"))  insanKaynaklari(personelOzellik());
            else if (secim2.equals("Müdür"))  mudur(personelOzellik());
            else if (secim2.equals("Muhasebe Personeli")) muhasebe(personelOzellik());
            else if (secim2.equals("Teknik Personel"))  teknik(personelOzellik());
            else {
                for (int i = 0; i<departmanListesi.size();i++){
                    if(departmanListesi.get(i).getAd().equals(secim2)){
                        baskaDep(personelOzellik());
                        anaMenu();
                    }
                }
                System.out.println("Böyle bir departman bulunamadı, departman listesi: ");
                System.out.println(dc.findAll().stream().toList());
                personelEkleme();
            }
    }
    public Queue<String> personelOzellik(){
        sc = new Scanner(System.in);
        Queue<String> personelOzellik = new LinkedList<String>();
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
        System.out.println("Personel maaşı giriniz.");
        personelOzellik.add(sc.nextLine());
        System.out.println("Personel işe giriş tarihi giriniz.");
        personelOzellik.add(sc.nextLine());

        return personelOzellik;

    }
    public void buroPersoneli(Queue<String> personelOzellik){
        System.out.println("birim giriniz" );
        sc = new Scanner(System.in);
        String birim = sc.nextLine();
        Personel buroPersoneli = new BuroPersoneli(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(), personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),personelOzellik.poll(),birim,"Buro");

        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(buroPersoneli.getDepartman())){
               List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
               newList.add(buroPersoneli);
               departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(buroPersoneli);
        anaMenu();
    }

    public void genelMudur(Queue<String> personelOzellik){
        System.out.println("Müdürün sorumlu olduğu departmanları giriniz");
        sc = new Scanner(System.in);
        String sorumluOlduguDepartmanlar = sc.nextLine();
        Personel genelMudur = new GenelMudur(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),sorumluOlduguDepartmanlar,"Genel Müdür");
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(genelMudur.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(genelMudur);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(genelMudur);
        anaMenu();
    }
    public void hizmetli(Queue<String> personelOzellik){
        System.out.println("Hizmet alani belirleyiniz");
        sc = new Scanner(System.in);
        String hizmetAlani = sc.nextLine();
        int calismaSaatleri = sc.nextInt();
        Personel hizmetli = new Hizmetli(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),hizmetAlani,calismaSaatleri,"Hizmetli");
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(hizmetli.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(hizmetli);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(hizmetli);
        anaMenu();

    }
    public void insanKaynaklari(Queue<String> personelOzellik){
        System.out.println("calismaAlani nedir");
        sc = new Scanner(System.in);
        String calismaAlani = sc.nextLine();
        Personel insanKaynaklari = new InsanKaynaklariPersoneli(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),calismaAlani,"Insan Kaynaklari");
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(insanKaynaklari.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(insanKaynaklari);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(insanKaynaklari);
        anaMenu();
    }
    public void mudur(Queue<String> personelOzellik){
        System.out.println("Sorumlu olduğu departmanı girin:");
        sc = new Scanner(System.in);
        String sorumluOlduguDepartman = sc.nextLine();
        Personel mudur = new Mudur(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),sorumluOlduguDepartman,"Mudur");
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(mudur.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(mudur);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(mudur);
        anaMenu();
    }

    public void muhasebe(Queue<String> personelOzellik){
        System.out.println("Eklenecek maaş giriniz");
        sc = new Scanner(System.in);
        double maasEkle = sc.nextDouble();
        Personel muhasebe = new MuhasebePersoneli(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),maasEkle,"Muhasebe");
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(muhasebe.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(muhasebe);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(muhasebe);
        anaMenu();
    }
    public void teknik(Queue<String> personelOzellik){
        System.out.println("Bilgi seviyesi giriniz (orta-az-çok)");
        sc = new Scanner(System.in);
        String bilgiSeviyesi = sc.nextLine();
        Personel teknik = new TeknikPersonel(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),bilgiSeviyesi,"Teknik");
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(teknik.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(teknik);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(teknik);
        anaMenu();
    }
    public void baskaDep(Queue<String> personelOzellik){
        Personel baska = new Personel(personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),personelOzellik.poll(),
                personelOzellik.poll(),Integer.parseInt(personelOzellik.poll()),
                personelOzellik.poll(),secim2);
        for(int i = 0 ; i< departmanListesi.size();i++){
            if(departmanListesi.get(i).getAd().equalsIgnoreCase(baska.getDepartman())){
                List<Personel> newList = departmanListesi.get(i).getPersonelListesi();
                newList.add(baska);
                departmanListesi.get(i).setPersonelListesi(newList);
            }
        }
        ps.save(baska);
        System.out.println(baska.getId());
        anaMenu();
    }

































 /*       DepartmanController dp = new DepartmanController();
        private final PersonelService personelService;
        private static Scanner sc = new Scanner(System.in);

        int secim;
        public PersonelController(){
            personelService = new PersonelService();
        }
        Stack<String> personelOzellik = new Stack<>();

    public void update(Personel personel){
        personelService.update(personel);
    }

    public void delete(Long id){
        personelService.delete(null);
    }
    public void findAll(){
            personelService.findAll().forEach(System.out::println);
        }

    public Personel findById(Long id){
        return personelService.findById(id);
    }

    public void anaMenu(){


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



    }
    public void personelIslemleriMenu() {
        int secim;

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
                String email = sc.nextLine();
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
                dp.save();
                break;
            case 5:
                System.out.println(dp.findAll().stream().toList());
            break;
            case 6:
                anaMenu();
                break;
            default:
                System.out.println("Geçersiz seçim!");
                personelIslemleriMenu();
                break;
        }

    }

    public void personelEkleme(){

                System.out.println("1. Buro Personeli");
                System.out.println("2. Genel Mudur");
                System.out.println("3. Hizmetli");
                System.out.println("4. Insan Kaynaklari");
                System.out.println("5. Mudur");
                System.out.println("6. Muhasebe Personeli");
                System.out.println("7. Teknik Personel");
                System.out.println("Eklemek istediginiz personel tipini seciniz");
                int secim2 = sc.nextInt();
                switch (secim2) {
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
                    default:
                        System.out.println("Geçersiz seçim yaptınız");
                        personelService.findAll();
                        anaMenu();
                        break;
                }

    }

    public Stack<String> personelOzellik(){
        System.out.println("asjkdasd");
        sc = new Scanner(System.in);

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
        System.out.println("123124234");

        return personelOzellik;

    }
    public void buroPersoneli(Stack<String> strings){
        System.out.println("birim giriniz" );
        sc = new Scanner(System.in);
        String birim = sc.nextLine();
        System.out.println(birim);
            BuroPersoneli buroPersoneli = new BuroPersoneli(personelOzellik.pop(),personelOzellik.pop(),
                                     personelOzellik.pop(),personelOzellik.pop(),
                                     personelOzellik.pop(),Integer.parseInt(personelOzellik.pop()),personelOzellik.pop(),birim);

            personelService.save(buroPersoneli);
    }
    public void buroPersoneli(Stack<String> personelOzellik) {
        sc = new Scanner(System.in);
        System.out.println("Dosyalama hizi giriniz.");
        String birim = sc.nextLine();

        Personel buroPersoneli = new BuroPersoneli(personelOzellik.pop(),
                personelOzellik.pop(),
                personelOzellik.pop(),
                personelOzellik.pop(),personelOzellik.pop(),
                Integer.parseInt(personelOzellik.pop()),
                personelOzellik.pop(),
                birim);
        personelService.save(buroPersoneli);
    }
    public void genelMudur(Stack<String> strings){
        System.out.println("Müdürün sorumlu olduğu departmanları giriniz");
            sc = new Scanner(System.in);
            String sorumluOlduguDepartmanlar = sc.nextLine();
            Personel genelMudur = new GenelMudur(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),sorumluOlduguDepartmanlar);
            personelService.save(genelMudur);
    }
    public void hizmetli(Stack<String> strings){
        System.out.println("Hizmet alani belirleyiniz");
            sc = new Scanner(System.in);
            String hizmetAlani = sc.nextLine();
            int calismaSaatleri = sc.nextInt();
            Personel hizmetli = new Hizmetli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),hizmetAlani,calismaSaatleri);

    }
    public void insanKaynaklari(Stack<String> strings){
        System.out.println("calismaAlani nedir");
            sc = new Scanner(System.in);
            String calismaAlani = sc.nextLine();
            Personel insanKaynaklari = new InsanKaynaklariPersoneli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),calismaAlani);
            personelService.save(insanKaynaklari);
    }
    public void mudur(Stack<String> strings){
        System.out.println("Sorumlu olduğu departmanlar");
            sc = new Scanner(System.in);
            String sorumluOlduguDepartman = sc.nextLine();
            Personel mudur = new Mudur(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),sorumluOlduguDepartman);
            personelService.save(mudur);
    }

    public void muhasebe(Stack<String> strings){
        System.out.println("Eklenecek maaş giriniz");
            sc = new Scanner(System.in);
            double maasEkle = sc.nextDouble();
            Personel muhasebe = new MuhasebePersoneli(personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),personelOzellik().pop(),
                    personelOzellik().pop(),Integer.parseInt(personelOzellik().pop()),
                    personelOzellik().pop(),maasEkle);
            personelService.save(muhasebe);
    }
    public void teknik(Stack<String> strings){
        System.out.println("Bilgi seviyesi giriniz (orta-az-çok)");
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




*/

}