package com.yavuzavci.utility.menu;

import static com.yavuzavci.utility.StaticValues.*;

/**
 * Uygulama ana menüsü.
 * @author Yavuz AVCI
 */
public class AnaMenu implements IMenu {

    private void anaMenuBaslik(){
        System.out.println("************************************************************");
        System.out.println("*************** PERSONEL TAKİP SİSTEMİ *********************");
        System.out.println("************************************************************");
        System.out.println("1 -> Personel İşlemleri");
        System.out.println("2 -> Muhasebe İşlemleri");
        System.out.println("3 -> Raporlama");
        System.out.println("0 -> Uygulamayı Kapat");
    }

    @Override
    public void menu() {
        int secim = 0;
        do{
            anaMenuBaslik();
            System.out.print("Lütfen seçiminizi yapınız...: ");
            secim = SCANNER.nextInt();
            SCANNER.nextLine();
            islemSec(secim);
        } while (secim != 0);
        SCANNER.close();
        System.out.println("Uygulama sonlandırıldı.");
        System.exit(0);
    }

    @Override
    public void islemSec(int secim) {
        switch(secim){
            case 1:
                PERSONEL_MENU.menu();
                break;
            case 2:
                MUHASEBE_MENU.menu();
                break;
            case 3:
                RAPORLAMA_MENU.menu();
                break;
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
