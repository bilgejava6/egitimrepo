package aradonemodev.repository.entity;

import aradonemodev.utility.StaticValues;

public class Hizmetli extends Personel{
    public Hizmetli(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
