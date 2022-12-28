package com.yavuzavci.utility.menu;

import static com.yavuzavci.utility.StaticValues.*;

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
                personelController.save();
                break;
            case 2:
                if(personelController.findAll().isEmpty()){
                    System.out.println("Bilgi : Sistemde kayıtlı personel bulunmamaktadır.");
                    break;
                }
                System.out.println("### Personel Listesi ###");
                personelController.findAll().forEach(System.out::println);
                break;
            case 3:
                if(personelController.findAll().isEmpty()){
                    System.err.println("HATA: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.print("Bilgilerini güncellemek istediğiniz personelin numarasını giriniz..: ");
                long id = scanner.nextLong();
                if(personelController.findById(id).equals(null)){
                    System.err.println("HATA: Sistemde " + id + " numaralı personel yoktur.");
                    break;
                }
                personelController.update();
                break;
            case 4:
                departmanController.save();
                break;
            case 5:
                if(departmanController.findAll().isEmpty()){
                    System.out.println("Bilgi : Sistemde kayıtlı departman bulunmamaktadır.");
                    break;
                }
                System.out.println("### Departman Listesi ###");
                departmanController.findAll().forEach(System.out::println);
                break;
            case 0:
                break;
            default:
                System.err.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
