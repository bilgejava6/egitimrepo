package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

public class IKPersoneli extends Personel{
    public IKPersoneli(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
