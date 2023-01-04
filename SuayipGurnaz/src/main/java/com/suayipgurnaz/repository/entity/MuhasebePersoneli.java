package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

public class MuhasebePersoneli extends Personel{
    public MuhasebePersoneli(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
        this.setDepartman("MUHASEBE");
    }
}
