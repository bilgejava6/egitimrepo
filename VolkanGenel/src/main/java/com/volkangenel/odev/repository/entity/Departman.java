package com.volkangenel.odev.repository.entity;

import odev.repository.entity.utility.StaticValues;

public class Departman {
    Long id;
    String ad;

    public Departman(String ad) {
        this.id = StaticValues.departmanidOlustur();
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
