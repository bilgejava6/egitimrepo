package com.yavuzavci.utility.menu;

import static com.yavuzavci.utility.StaticValues.anaMenu;
import static com.yavuzavci.utility.StaticValues.scanner;

public class RaporlamaMenu extends AnaMenu {
    private void raporlamaMenuBaslik(){
        System.out.println("*************************************************************");
        System.out.println("******************* RAPORLAMA İŞLEMLERİ *********************");
        System.out.println("*************************************************************");
        System.out.println("1 -> Departman Personel Listesi");
        System.out.println("2 -> En Çok Personel Bulunan Departman");
        System.out.println("3 -> Departmanlara Göre Maaş Ortalamaları");
        System.out.println("4 -> Müdürlerin Sorumlu Olduğu Departman Listesi");
        System.out.println("5 -> Kayıt Tarihlerine Göre Persollerin Sıralı Listesi");
        System.out.println("6 -> Aynı Gün İçinde İşe Başlayan Personellerin Listesi");
        System.out.println("0 -> Ana Menüye Dön");
    }
    @Override
    public void menu() {
        int secim = 0;
        do{
            raporlamaMenuBaslik();
            System.out.print("Lütfen seçiminizi yapınız...: ");
            secim = scanner.nextInt();
            scanner.nextLine();
            islemSec(secim);
        } while (secim != 0);
        anaMenu.menu();
    }

    @Override
    public void islemSec(int secim) {
        switch(secim){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 0:
                break;
            default:
                System.err.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
