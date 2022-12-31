package com.yavuzavci.utility.menu;

import com.yavuzavci.entity.Personel;

import java.util.Objects;

import static com.yavuzavci.utility.PersonelUtility.*;
import static com.yavuzavci.utility.StaticValues.*;

/**
 * Muhasebe işlemlerinin yapıldığı menü.
 * @author Yavuz AVCI
 */
public class MuhasebeMenu implements IMenu {
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
            secim = SCANNER.nextInt();
            SCANNER.nextLine();
            islemSec(secim);
        } while (secim != 0);
        ANA_MENU.menu();
    }

    @Override
    public void islemSec(int secim) {
        long id;
        Personel personel;
        switch(secim){
            case 1:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("HATA: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.print("Personel numaranızı giriniz..: ");
                id = SCANNER.nextLong();
                personel = PERSONEL_CONTROLLER.findById(id);
                if(!personel.isMaasTanimlayabilirMi()){
                    System.out.println("HATA: Maaş tanımlama yetkiniz yoktur. İşlem başarısız.");
                    break;
                }
                System.out.print("Maaş bilgisini tanımlayacağınız personelin numarasını giriniz..: ");
                id = SCANNER.nextLong();
                personel = PERSONEL_CONTROLLER.findById(id);
                if (Objects.isNull(personel)) {
                    System.out.println("HATA: Sistemde " + id + " numaralı personel yoktur.");
                    break;
                }
                Double maas = maasAl();
                personel.setMaas(maas);
                PERSONEL_CONTROLLER.findAll()
                        .set(PERSONEL_CONTROLLER.findAll().indexOf(personel), personel);
                DEPARTMAN_CONTROLLER.findById(personel.getDepartman().getId())
                        .getPersonelListesi()
                        .set(DEPARTMAN_CONTROLLER.findById(personel.getDepartman().getId())
                                .getPersonelListesi().indexOf(personel),
                                personel);
                System.out.println("Personel maaş bilgisi tanımlandı.");
                break;
            case 2:
                if (PERSONEL_CONTROLLER.findAll().isEmpty()) {
                    System.out.println("HATA: Sistemde kayıtlı personel yoktur.");
                    break;
                }
                System.out.print("Kaç personele ödeme yapılacağını giriniz..: ");
                int personelSayisi = SCANNER.nextInt();
                if (personelSayisi <= 0) {
                    System.out.println("HATA: En az 1 personel için ödeme yapmak zorundasınız.");
                    break;
                }
                for (int i = 0; i < personelSayisi; i++) {
                    System.out.print("Maaş bilgisini tanımlayacağınız personelin numarasını giriniz..: ");
                    id = SCANNER.nextLong();
                    personel = PERSONEL_CONTROLLER.findById(id);
                    if (Objects.isNull(personel)) {
                        System.out.println("HATA: Sistemde " + id + " numaralı personel yoktur.");
                        System.out.println("İşlem personel için başarısız.");
                        continue;
                    }
                    System.out.println("Personele maaş ödemesi yapacaksanız 'maas'\n" +
                            "Başka bir tutar ödemesi yapacaksanız 'diger' yazmalısınız.");
                    System.out.print("Seçiminizi yapınız..: ");
                    String odemeSecim= SCANNER.nextLine();
                    switch (odemeSecim.toLowerCase()){
                        case "maas":
                            personel.setOdenmisUcret(personel.getMaas());
                            PERSONEL_CONTROLLER.findAll()
                                    .set(PERSONEL_CONTROLLER.findAll().indexOf(personel), personel);
                            DEPARTMAN_CONTROLLER.findById(personel.getDepartman().getId())
                                    .getPersonelListesi()
                                    .set(DEPARTMAN_CONTROLLER.findById(personel.getDepartman().getId())
                                                    .getPersonelListesi().indexOf(personel),
                                            personel);
                            break;
                        case "diger":
                            System.out.print("Personele ödenecek tutarı giriniz..: ");
                            Double tutar = SCANNER.nextDouble();
                            if(tutar <= 0){
                                System.out.println("HATA: Ödenecek tutar sıfırdan büyük olmalıdır.");
                                System.out.println("İşlem personel için başarısız.");
                                break;
                            }
                            personel.setOdenmisUcret(tutar);
                            PERSONEL_CONTROLLER.findAll()
                                    .set(PERSONEL_CONTROLLER.findAll().indexOf(personel), personel);
                            DEPARTMAN_CONTROLLER.findById(personel.getDepartman().getId())
                                    .getPersonelListesi()
                                    .set(DEPARTMAN_CONTROLLER.findById(personel.getDepartman().getId())
                                                    .getPersonelListesi().indexOf(personel),
                                            personel);
                            break;
                        default:
                            System.out.println("HATA: Geçersiz seçim.");
                            System.out.println("İşlem personel için başarısız.");
                            break;
                    }
                }
                break;
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }
}
