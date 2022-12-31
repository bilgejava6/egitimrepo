package aradonemodev.repository.entity;

import aradonemodev.utility.StaticValues;

public class TeknikPersonel extends Personel{
    public TeknikPersonel(String ad, String iseBaslamaTarihi, double maas) {
        this.setId(StaticValues.personlerIdOlustur());
    }

    public TeknikPersonel(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
