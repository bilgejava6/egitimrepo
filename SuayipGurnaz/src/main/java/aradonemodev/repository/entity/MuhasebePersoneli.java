package aradonemodev.repository.entity;

import aradonemodev.utility.StaticValues;

public class MuhasebePersoneli extends Personel{
    public MuhasebePersoneli(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
