package com.AraDonemOdevi.Controller;

import com.AraDonemOdevi.Entity.Departman;
import com.AraDonemOdevi.Entity.Personel;
import com.AraDonemOdevi.Service.DepartmanService;
import com.AraDonemOdevi.Service.PersonelService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Controller {

    private final PersonelService personelService;

    private final DepartmanService departmanService;
    private static Scanner sc;


    public Controller() {

        this.personelService = new PersonelService();
        this.departmanService = new DepartmanService();
    }

    public static void run() {
        Controller controller = new Controller();
        sc = new Scanner(System.in);
        int secim = 0;

        do{
            System.out.println("Lutfen Bir Secim Yapiniz.");
            System.out.println("1- Personel Islemleri");
            System.out.println("2- Muhasebe Islemleri");
            System.out.println("3- Raporlamalar");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    sc = new Scanner(System.in);
                    int secim1 = 0;
                    do {
                        System.out.println("Bir Personel Islemi Secin.");
                        System.out.println("1.1- Personel Ekleme");
                        System.out.println("1.2- Personel Listesi");
                        System.out.println("1.3- Personel Duzenleme");
                        System.out.println("1.4- Departman Ekleme");
                        System.out.println("1.5- Departman Listesi");
                        System.out.println("1.0- Cikis");
                        secim1 = sc.nextInt();
                          switch (secim1) {
                            case 1:
                                controller.savePersonel();
                                break;
                            case 2:
                                controller.findAllPersonel();
                                break;
                            case 3:
                                controller.updatePersonel();
                                break;
                            case 4:
                                controller.saveDepartman();
                                break;
                            case 5:
                                controller.findAllDepartman();
                                break;
                            case 0:
                                System.out.println("Cikis.");
                                break;
                            default:
                                System.out.println("Gecerli Bir Secim Yapiniz Lutfen.");
                                break;
                        }
                    } while (secim1!=0);
                    break;
                case 2:
                    sc = new Scanner(System.in);
                    int secim2 = 0;
                    do {
                        System.out.println("Bir Muhasebe Islemi Secin.");
                        System.out.println("2.1- Maas Personel Tanimlama");
                        System.out.println("2.2- Odeme Listesi");
                        System.out.println("2.0- Cikis");
                        secim2 = sc.nextInt();
                        switch (secim2){
                            case 1:
                                controller.updatePersonelMaas();
                                break;
                            case 2:
                                controller.findAllPersonelMaas();
                                break;
                            case 0:
                                System.out.println("Cikis.");
                                break;
                            default:
                                System.out.println("Gecerli Bir Secim Yapiniz Lutfen.");
                                break;
                        }
                    }while(secim2!=0);
                    break;
                case 3:
                    sc = new Scanner(System.in);
                    int secim3 = 0;
                    do{
                        System.out.println("3.1- Departman Personel Listesi");
                        System.out.println("3.2- En Cok Personel Bulunan Departman");
                        System.out.println("3.3- Departmanlara Gore Maas Ortalamalari");
                        System.out.println("3.4- Mudurlerin Sorumlu Oldugu Departman Listesi");
                        System.out.println("3.5- Kayit Tarihine Gore Personellerin Sirali Listesi");
                        System.out.println("3.6- Aynı Gun Icerisinde Ise Baslayan Personel Listesi");
                        secim3 = sc.nextInt();
                        switch (secim3){
                            case 1:
                                controller.departmanPersonelListesi();
                                break;
                            case 2:
                                controller.enCokPersonelBulunanDepartman();
                                break;
                            case 3:
                                controller.departmanlaraGoreMaasOrt();
                                break;
                            case 4:
                                //mudurlerinSorumluOlduguDepartmanList();
                                break;
                            case 5:
                                //kayitTarihineGorePersonelList();
                                break;
                            case 6:
                                //ayniGuniseBaslayanlarinList();
                                break;
                            case 0:
                                System.out.println("Cikis.");
                            default:
                                System.out.println("Gecerli bir secim yapiniz lütfen.");
                        }
                    }while(secim3!=0);
            }
        }while(secim!=0);


        }

    private void departmanlaraGoreMaasOrt() {
        Map<String, Double> departmanMaas = new HashMap<>();

        personelService.findAll().forEach((k,v) ->{
            departmanMaas.put(v.getDepartman(), 0.0);
        });
        personelService.findAll().forEach((k,v)->{

            departmanMaas.put(v.getDepartman(), departmanMaas.get(v.getDepartman()) + v.getMaas());
        });
        departmanMaas.forEach((k,v) -> {
            System.out.println(k + " departmani maas ortalamasi..: " + v  );
        });


    }

    public void enCokPersonelBulunanDepartman() {

        Map<String, Integer> departmanlar = new HashMap<>();

        personelService.findAll().forEach((k,v) ->{
            departmanlar.put(v.getDepartman(),0);
        });

        personelService.findAll().forEach((k,v)->{
                departmanlar.put(v.getDepartman(), departmanlar.get(v.getDepartman())+1);
        });
        departmanlar.forEach((k,v) -> {
            System.out.println(k + " - " + v + " adet personel.");
        });
    }

    public Personel departmanPersonelListesi() {
        //hangi departmani istiyorsun
        System.out.println("Listelemek istediginiz Departmani Secin.");
        sc = new Scanner(System.in);
        String departmanList = sc.nextLine();

            personelService.findAll().forEach((k,v)->{
                if(departmanList.equalsIgnoreCase(v.getDepartman()))
                    System.out.println(departmanList + " : " + v.getAd() + " " + v.getSoyad());
            });
            return  null;
    }



    public void findAllPersonel() {
        personelService.findAll().forEach((k,v)->{
            System.out.println("Departman....: " +v.getDepartman());
            System.out.println("id...........: " +v.getId());
            System.out.println("Ad...........: " +v.getAd());
            System.out.println("Soyad........: " +v.getSoyad());
            System.out.println("Maas.........: " +v.getMaas());
            System.out.println("Olusturulma..: " +v.getCreateDate());

        });
    }

    public void savePersonel() {
        sc = new Scanner(System.in);
        System.out.println("Lutfen personel ismi girin...:");
        String PersAd = sc.nextLine();
        System.out.println("Lutfen personel soyadi girin...:");
        String perSoyad = sc.nextLine();
        System.out.println("Lutfen personel departmani girin...:");
        String departman = sc.nextLine();

        personelService.save(PersAd, perSoyad, departman);
    }

    public void saveDepartman() {
        System.out.println("Eklemek Istediginiz Departmani Girin Lutfen.");
        sc = new Scanner(System.in);
        String yeniDepartman = sc.nextLine();

        Departman d = new Departman();
        d.setAd(yeniDepartman);

        departmanService.save(d);
    }
    private void findAllDepartman() {
        departmanService.findAll().forEach(v->{

            System.out.println("Departman Ad..: " +v.getAd());
            System.out.println("Olusturulma...: " +v.getCreateDate());

        });
    }

    public void updatePersonel() {

        System.out.println("Update Etmek Istediginiz Personel id'sini gir");
        Long id = sc.nextLong();
        Personel degisecek = findPersonelById(id);
        Personel yeniPersonel = new Personel();
        yeniPersonel.setId(degisecek.getId());
        System.out.println("Update Etmek Istediginiz Personel ismini girin");
        sc = new Scanner(System.in);
        yeniPersonel.setAd(sc.nextLine());
        System.out.println("Update Etmek Istediginiz Personel soyadi girin");
        yeniPersonel.setSoyad(sc.nextLine());
        System.out.println("Update Etmek Istediginiz Personel departman girin");
        yeniPersonel.setDepartman(sc.nextLine());

        personelService.update(degisecek,yeniPersonel);

    }

    public void updatePersonelMaas() {

        System.out.println("Update Etmek Istediginiz Personel id'sini gir");
        Long id = sc.nextLong();
        Personel degisecek = findPersonelById(id);
        Personel yeniPersonel = new Personel();
        yeniPersonel.setId(degisecek.getId());
        yeniPersonel.setAd(degisecek.getAd());
        yeniPersonel.setSoyad(degisecek.getSoyad());
        yeniPersonel.setDepartman(degisecek.getDepartman());
        sc = new Scanner(System.in);
        System.out.println(degisecek.getAd() + " icin maas girin");
        yeniPersonel.setMaas(sc.nextInt());

        personelService.update(degisecek,yeniPersonel);

    }

    public Personel findPersonelById(Long id) {
        return personelService.findById(id);
    }

    private void findAllPersonelMaas() {
        personelService.findAll().forEach((k,v)->{
            System.out.println(String.valueOf(k) + "- " + v.getAd() + " " + v.getSoyad() + " " + v.getMaas());
          });
    }


}
