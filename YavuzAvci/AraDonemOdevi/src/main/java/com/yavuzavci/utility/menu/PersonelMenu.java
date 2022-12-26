package com.yavuzavci.utility.menu;

import static com.yavuzavci.utility.StaticValues.anaMenu;
import static com.yavuzavci.utility.StaticValues.scanner;

public class PersonelMenu extends AnaMenu {
    private void personelMenuBaslik(){
        System.out.println("************************************************************");
        System.out.println("******************* PERSONEL İŞLEMLERİ *********************");
        System.out.println("************************************************************");
        System.out.println("1 -> Personel Ekleme");
        System.out.println("2 -> Personel Listesi");
        System.out.println("3 -> Personel Düzenleme");
        System.out.println("4 -> Departman Ekleme");
        System.out.println("5 -> Departman Listesi");
        System.out.println("0 -> Ana Menüye Dön");
    }
    @Override
    public void menu() {
        int secim = 0;
        do{
            personelMenuBaslik();
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
            case 0:
                break;
            default:
                System.err.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
