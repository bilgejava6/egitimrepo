package com.beratacer.repository.entity;

public class Departman {
    private Long id;
    private String ad;


    public Departman(String ad) {
        //this.id = ++StaticValues.departmanId;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                '}';
    }
}
