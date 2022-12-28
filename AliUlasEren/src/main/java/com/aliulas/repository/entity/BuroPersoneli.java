package com.aliulas.repository.entity;

public class BuroPersoneli extends Personel{
    private String birim;
    public BuroPersoneli() {
    }

    public BuroPersoneli(String ad, String soyad, String email, String telefon, String pozisyon, int maas, String kayitTarihi, String birim) {
        super(ad, soyad, email, telefon,  pozisyon, maas, kayitTarihi);
        this.birim = birim;
    }

    public BuroPersoneli(String birim) {
        super();
        this.birim = birim;
    }


    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    @Override
    public String toString() {
        return "BuroPersoneli [ birim=" + birim + "]";
    }

}
