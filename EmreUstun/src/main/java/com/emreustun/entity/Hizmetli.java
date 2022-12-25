package com.emreustun.entity;

import java.util.ArrayList;
import java.util.List;

public class Hizmetli extends Personel{
    List<String> calismaYerleri = new ArrayList<>();

    public Hizmetli() {
    }

    @Override
    public String toString() {
        return "Hizmetli{" +
                "calismaYerleri=" + calismaYerleri +
                '}';
    }

    public List<String> getCalismaYerleri() {
        return calismaYerleri;
    }

    public void setCalismaYerleri(List<String> calismaYerleri) {
        this.calismaYerleri = calismaYerleri;
    }
}
