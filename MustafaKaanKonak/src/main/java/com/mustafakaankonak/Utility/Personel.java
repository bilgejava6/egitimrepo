package com.mustafakaankonak.Utility;

import com.mustafakaankonak.IPersonel.IPersonel;

public class Personel implements IPersonel {

    String name;
    int maas;
    int id;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the maas
     */
    public int getMaas() {
        return maas;
    }
    /**
     * @param maas the maas to set
     */
    public void setMaas(int maas) {
        this.maas = maas;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    public Personel(String name,int id) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Personel [name=" + name + ", maas=" + maas + ", id=" + id + "]";
    }



}
