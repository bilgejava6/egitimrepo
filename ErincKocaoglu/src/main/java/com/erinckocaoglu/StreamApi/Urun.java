package com.erinckocaoglu.StreamApi;

public class Urun {

    String marka;
    String ad;

    public Urun() {
    }

    public Urun(String marka, String ad) {
        this.marka = marka;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "marka='" + marka + '\'' +
                ", ad='" + ad + '\'' +
                '}';
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getMarka() {
        return marka;
    }
}
