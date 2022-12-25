package com.emreustun.entity;

public class BuroPersoneli extends Personel{
    private int ofisNo;
    public BuroPersoneli(String isim, int maas, int yas, ECinsiyet cinsiyet, String egitimSeviyesi, Departman departman, int ofisNo) {
        super(isim, maas, yas , cinsiyet, departman);
        this.ofisNo = ofisNo;
    }

    @Override
    public String toString() {
        return "BuroPersoneli{" +
                "ofisNo=" + ofisNo +
                '}';
    }

    public int getOfisNo() {
        return ofisNo;
    }

    public void setOfisNo(int ofisNo) {
        this.ofisNo = ofisNo;
    }
}
