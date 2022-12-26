package com.emreustun.entity;

public class InsanKaynaklariPersoneli extends Personel{
    int ofisNo;

    public InsanKaynaklariPersoneli() {
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
