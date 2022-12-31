package com.beratacer.utility;

import com.beratacer.controller.DepartmanController;
import com.beratacer.controller.PersonelController;

import static com.beratacer.utility.StaticValues.*;
import static java.lang.Integer.parseInt;

public class MenuManager {

    private PersonelController personelController;
    private DepartmanController departmanController;
    private MenuValues menu;

    public MenuManager() {
        this.personelController = new PersonelController();
        this.departmanController = new DepartmanController();
        this.menu=new MenuValues();
    }

    public void runner(){
        int secim;
        do {
            secim=menu.anaMenu();
            switch (secim){
                case 1 : personelIslemleriRunner(); break;
                case 2 : muhasebeIslemleriRunner(); break;
                case 3 : raporlamalarRunner(); break;
                case 0 :
                    System.out.println("Cikis yapildi...");
                default:
                    System.out.println("Lutfen gecerli bir secim yapiniz..");
            }

        }while(secim!=0);

    }
    public void personelIslemleriRunner(){
        switch (menu.personelIslemleri()){
            case 1 : personelController.save(); break;
            case 2 : personelController.findAll(); break;
            case 3 : personelController.update(); break;
            case 4 : departmanController.save(); break;
            case 5 : departmanController.findAll(); break;
            default:
                System.out.println("Lutfen gecerli bir secim yapiniz..");
        }
    }
    public void muhasebeIslemleriRunner(){
        switch (menu.muhasebeIslemleri()){
            case 1 : personelController.maasPersonelTanimlama();
                stringScanner("");// Scanner hatasından kurtulmak icin eklendi.
                break;
            case 2 : personelController.getOdemeListesi(); break;
            default:
                System.out.println("Lutfen gecerli bir secim yapiniz..");
        }
    }

    public void raporlamalarRunner(){
        switch (menu.raporlamalar()){
            case 1 : departmanController.getDepartmanPersonelListesi(); break;
            case 2 : departmanController.getEnCokPersonelliDepartman(); break;
            case 3 : departmanController.getDepartmanlaraGoreMaasOrtalamasi(); break;
            case 4 : personelController.getSorumluOlunanDepartmanlar(); break;
            case 5 : personelController.getKayitTarihlerineGorePersoneller(); break;
            case 6 : personelController.getAyniTarihliPersoneller(); break;
            default:
                System.out.println("Lutfen gecerli bir secim yapiniz..");
        }
    }
}
