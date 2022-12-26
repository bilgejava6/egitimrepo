package com.emreustun.entity;

import java.util.ArrayList;
import java.util.List;

public class Hizmetli extends Personel{
    private String calismaYeri;

    public Hizmetli() {
    }

    public String getCalismaYeri() {
        return calismaYeri;
    }

    public void setCalismaYeri(String calismaYeri) {
        this.calismaYeri = calismaYeri;
    }
}
