package com.yavuzavci.utility.menu;

import static com.yavuzavci.utility.StaticValues.anaMenu;
import static com.yavuzavci.utility.StaticValues.scanner;

public class MuhasebeMenu extends AnaMenu {
    private void muhasebeMenuBaslik(){
        System.out.println("********************************************************");
        System.out.println("*************** MUHASEBE İŞLEMLERİ *********************");
        System.out.println("********************************************************");
        System.out.println("1 -> Personel Maaş Tanımlama");
        System.out.println("2 -> Ödeme Listesi");
        System.out.println("0 -> Uygulamayı Kapat");
    }

    @Override
    public void menu() {
        int secim = 0;
        do{
            muhasebeMenuBaslik();
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
            case 0:
                break;
            default:
                System.err.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
