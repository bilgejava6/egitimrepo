package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

public class BuroPersoneli extends Personel{
    public BuroPersoneli(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
