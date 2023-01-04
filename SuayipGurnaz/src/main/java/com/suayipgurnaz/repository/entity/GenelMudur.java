package com.suayipgurnaz.repository.entity;

import com.suayipgurnaz.utility.StaticValues;

import java.util.LinkedHashSet;
import java.util.Set;

public class GenelMudur extends Mudur{
    private Set<Mudur> bagliMudurler;
   
    public GenelMudur(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
