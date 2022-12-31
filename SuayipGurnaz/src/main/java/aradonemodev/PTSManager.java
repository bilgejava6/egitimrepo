package aradonemodev;

import aradonemodev.controller.DepartmanController;
import aradonemodev.controller.PersonelController;
import aradonemodev.repository.entity.Departman;
import aradonemodev.repository.entity.Mudur;
import aradonemodev.repository.entity.Personel;
import aradonemodev.utility.PtsUtility;

import java.util.stream.Collectors;

public class PTSManager {
    public PersonelController personelController;
    public DepartmanController departmanController;

    public void run(){

        int secim=0;
        int secim2=0;
        do{
            anaMenu();
            secim= PtsUtility.intDegerAlma("İşlem Seçiniz...: ");
            switch (secim){
                case 1:
                    personelIslemleriMenu();
                    secim2= PtsUtility.intDegerAlma("İşlem Seçiniz...: ");
                    switch (secim2){
                        case 1:
                            personelController.save();
                            break;
                        case 2:
                            personelController.findAll();
                            break;
                        case 3:
                            personelController.update();
                            break;
                        case 4:
                            departmanController.save();
                            break;
                        case 5:
                            departmanController.findAll();
                            break;
                        default:
                            System.out.println("Uygun değer girmediniz");
                    }
                    break;
                case 2:
                    muhasebeIslemleriMenu();
                    secim2= PtsUtility.intDegerAlma("İşlem Seçiniz...: ");
                    switch (secim2){
                        case 1:
                            maasPersonelTanimlama();
                            break;
                        case 2:
                            odemeListesi();
                            break;
                        default:
                            System.out.println("Uygun değer girmediniz");
                    }
                    break;
                case 3:
                    raporlamalarMenu();
                    secim2= PtsUtility.intDegerAlma("İşlem Seçiniz...: ");
                    switch (secim2){
                        case 1:
                            departmanPersonelListesi();
                            break;
                        case 2:
                            enCokPersoneliOlanDepartman();
                            break;
                        case 3:
                            departmanMaasOrtalamalari();
                            break;
                        case 4:
                            mudurSorumlulukListesi();
                            break;
                        case 5:
                            kayitTarihineGorePersonelListesi();
                            break;
                        case 6:

                            break;
                        default:
                            System.out.println("Uygun değer girmediniz");
                    }
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Uygun bir değer girmediniz...");
                    break;
            }
        }while(secim!=0);
    }

    private void kayitTarihineGorePersonelListesi() {

    }

    private void mudurSorumlulukListesi() {
        System.out.println("Müdür Sorumluluk Listesi");
        long mudurId=PtsUtility.intDegerAlma("Sorumluluk Listesini Görmek İStediğiniz Müdürün ID'sini giriniz..: ");
        for(int i=0; i<PtsUtility.personelList.size(); i++){
            if(PtsUtility.personelList.get(i).getId()==mudurId &&
                    PtsUtility.personelList.get(i).getClass().getSimpleName().equalsIgnoreCase("mudur")){
                Mudur mudur= (Mudur) PtsUtility.personelList.get(i);
                for(Departman departman : mudur.getSorumluOlduguDepartmanlar()){
                    System.out.println(departman.getAd());
                }
            }
        }
    }

    private void departmanMaasOrtalamalari() {
        System.out.println("Departmanlara göre maaş ortalamaları ");
        departmanPersonelMapYap();

        PtsUtility.personelMap.forEach((k,v)->{
            System.out.println(k.getAd()+"-"+v.stream().collect(Collectors.averagingDouble(z->z.getMaas())));
        });
    }
    private void enCokPersoneliOlanDepartman() {
        int max=0;
        int index=-1;
        for(int i=0; i<PtsUtility.departmanList.size(); i++){
            if(PtsUtility.departmanList.get(i).getPersonelSayisi()>max) {
                max = PtsUtility.departmanList.get(i).getPersonelSayisi();
                index=i;
            }
        }
        System.out.println("En çok elemanı olan "+PtsUtility.departmanList.get(index).getAd()
        +" departmanının "+PtsUtility.departmanList.get(index).getPersonelSayisi()+" adet personeli vardır...");
    }

    private void departmanPersonelMapYap(){
         PtsUtility.personelMap = PtsUtility.personelList.stream().collect(Collectors.groupingBy(g->g.getDepartman()));
    }

    private void departmanPersonelListesi() {
        System.out.println("Departmanlara Göre Personel Listesi");
        departmanPersonelMapYap();
        PtsUtility.personelMap.forEach((x,y)->System.out.println(x+"-"+y));
    }

    private void odemeListesi() {
        System.out.println("Ödeme Listesi");
        PtsUtility.personelList.stream().filter(x->{
            if(x.getMaas()>0) {
                return true;
            } else{
            return false;
        }
        }).forEach(System.out::println);
    }

    private void maasPersonelTanimlama() {
        System.out.println("Maaş Personel Tanımlama");
        Personel personel = personelController.findById();
        personel.setMaas(PtsUtility.doubleDegerAlma("Personelin alacağı maaşı giriniz..:"));
    }

    public void anaMenu(){
        System.out.println();
        System.out.println("****** PERSONEL TAKİP SİSTEMİ *******");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("1- Personel İşlemleri");
        System.out.println("2- Muhasebe İşlemleri");
        System.out.println("3- Raporlamalar");
        System.out.println("0- Ç I K I Ş");
    }
    public void personelIslemleriMenu(){
        System.out.println("***** Personel İşlemleri *****");
        System.out.println("1- Personel Ekleme ");
        System.out.println("2- Personel Listesi ");
        System.out.println("3- Personel Düzenleme ");
        System.out.println("4- Departman Ekleme ");
        System.out.println("5- Departman Listesi ");
    }
    public void muhasebeIslemleriMenu(){
        System.out.println("***** Muhasebe İşlemleri *****");
        System.out.println("1- Maaş Personel Tanımlama ");
        System.out.println("2- Ödeme Listesi ");
    }
    public void raporlamalarMenu(){
        System.out.println("***** Raporlamalar *****");
        System.out.println("1- Departman Personel Listesi ");
        System.out.println("2- En Çok Personel Bulunduran Departman ");
        System.out.println("3- Departmanlara Göre Maaş Ortalamaları ");
        System.out.println("4- Müdürlerin Sorumlu Olduğu Departman Listesi ");
        System.out.println("5- Kayıt Tarihine Göre Personellerin Sıralı Listesi ");
        System.out.println("6- Aynı Gün İçinde İşe Başlayan Personellerin Listesi ");
    }
}

