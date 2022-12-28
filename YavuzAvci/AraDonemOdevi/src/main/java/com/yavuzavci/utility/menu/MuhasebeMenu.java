package com.yavuzavci.utility.menu;

import com.yavuzavci.entity.Personel;
import com.yavuzavci.utility.PersonelUtility;

import static com.yavuzavci.utility.StaticValues.*;
import static com.yavuzavci.utility.StaticValues.personelController;

public class MuhasebeMenu extends AnaMenu {
    private void muhasebeMenuBaslik(){
        System.out.println("********************************************************");
        System.out.println("*************** MUHASEBE İŞLEMLERİ *********************");
        System.out.println("********************************************************");
        System.out.println("1 -> Personel Maaş Tanımlama");
        System.out.println("2 -> Ödeme Listesi");
        System.out.println("0 -> Ana Menüye Dön");
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
        long id;
        Personel personel;
        switch(secim){
            case 1:
                if (personelController.findAll().isEmpty()) {
                    System.err.println("HATA: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.print("Maaş bilgisini tanımlayacağınız personelin numarasını giriniz..: ");
                id = scanner.nextLong();
                personel = personelController.findById(id);
                if (personel.equals(null)) {
                    System.err.println("HATA: Sistemde " + id + " numaralı personel yoktur.");
                    break;
                }
                Double maas = PersonelUtility.maasAl();
                personel.setMaas(maas);
                personelController.findAll()
                        .set(personelController.findAll().indexOf(personel), personel);
                System.out.println("Personel maaş bilgisi tanımlandı.");
                break;
            case 2:
                if (personelController.findAll().isEmpty()) {
                    System.err.println("HATA: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.print("Kaç personele ödeme yapılacağını giriniz..: ");
                int personelSayisi = scanner.nextInt();
                if (personelSayisi <= 0) {
                    System.err.println("HATA: En az 1 personel için ödeme yapmak zorundasınız.");
                    break;
                }
                for (int i = 0; i < personelSayisi; i++) {
                    System.out.print("Maaş bilgisini tanımlayacağınız personelin numarasını giriniz..: ");
                    id = scanner.nextLong();
                    personel = personelController.findById(id);
                    if (personel.equals(null)) {
                        System.err.println("HATA: Sistemde " + id + " numaralı personel yoktur.");
                        System.err.println("İşlem personel için başarısız.");
                        continue;
                    }
                    System.out.println("Personele maaş ödemesi yapacaksanız 'maas'\n" +
                            "Başka bir tutar ödemesi yapacaksanız 'diger' yazmalısınız.");
                    System.out.print("Seçiminizi yapınız..: ");
                    String odemeSecim= scanner.nextLine();
                    switch (odemeSecim.toLowerCase()){
                        case "maas":
                            personel.setOdenmisUcret(personel.getMaas());
                            personelController.findAll()
                                    .set(personelController.findAll().indexOf(personel), personel);
                            break;
                        case "diger":
                            System.out.print("Personele ödenecek tutarı giriniz..: ");
                            Double tutar = scanner.nextDouble();
                            if(tutar <= 0){
                                System.err.println("HATA: Ödenecek tutar sıfırdan büyük olmalıdır.");
                                System.err.println("İşlem personel için başarısız.");
                                break;
                            }
                            personel.setOdenmisUcret(tutar);
                            personelController.findAll()
                                    .set(personelController.findAll().indexOf(personel), personel);
                            break;
                        default:
                            System.err.println("HATA: Geçersiz seçim.");
                            System.err.println("İşlem personel için başarısız.");
                            break;
                    }
                }
                break;
            case 0:
                break;
            default:
                System.err.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
