package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

public class TeknikPersonel extends Personel{
    public TeknikPersonel(String ad, String iseBaslamaTarihi, double maas) {
        this.setId(StaticValues.personlerIdOlustur());
    }

    public TeknikPersonel(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
        this.setDepartman("TEKNIK");
    }
}
