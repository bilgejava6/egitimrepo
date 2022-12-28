package com.aliakkulah.entity;

import java.util.List;
import static com.aliakkulah.utility.Utility.*;

public class Departman {
    private String ad;
    private Long id;
    private List<Personel> personelList;

    public Departman(String ad) {
        this.ad = ad;
        this.id = depIdOlustur();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }
}