package com.emreustun.entity;

public class InsanKaynaklariPersoneli extends Personel{
    int ofisNo;

    public InsanKaynaklariPersoneli(String isim, int maas, int yas, ECinsiyet cinsiyet, Departman departman, int ofisNo) {
        super(isim, maas, yas, cinsiyet, departman);
        this.ofisNo = ofisNo;
    }

    public int getOfisNo() {
        return ofisNo;
    }

    public void setOfisNo(int ofisNo) {
        this.ofisNo = ofisNo;
    }

    @Override
    public String toString() {
        return "InsanKaynaklariPersoneli{" +
                "ofisNo=" + ofisNo +
                '}';
    }
}
