package com.yavuzavci.utility.menu;

import static com.yavuzavci.utility.StaticValues.*;

/**
 * Personel işlemlerinin yapıldığı menü.
 * @author Yavuz AVCI
 */
public class PersonelMenu implements IMenu {
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
            secim = SCANNER.nextInt();
            SCANNER.nextLine();
            islemSec(secim);
        } while (secim != 0);
        ANA_MENU.menu();
    }

    @Override
    public void islemSec(int secim) {
        switch(secim){
            case 1:
                PERSONEL_CONTROLLER.save();
                break;
            case 2:
                if(PERSONEL_CONTROLLER.findAll().isEmpty()){
                    System.out.println("Bilgi : Sistemde kayıtlı personel bulunmamaktadır.");
                    break;
                }
                System.out.println("### Personel Listesi ###");
                PERSONEL_CONTROLLER.findAll().forEach(System.out::println);
                break;
            case 3:
                if(PERSONEL_CONTROLLER.findAll().isEmpty()){
                    System.out.println("HATA: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                PERSONEL_CONTROLLER.update();
                break;
            case 4:
                DEPARTMAN_CONTROLLER.save();
                break;
            case 5:
                if(DEPARTMAN_CONTROLLER.findAll().isEmpty()){
                    System.out.println("Bilgi : Sistemde kayıtlı departman bulunmamaktadır.");
                    break;
                }
                System.out.println("### Departman Listesi ###");
                DEPARTMAN_CONTROLLER.findAll().forEach(System.out::println);
                break;
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
