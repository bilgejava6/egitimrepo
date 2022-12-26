package com.emreustun.entity;

public class BuroPersoneli extends Personel{
    private int ofisNo;
    public BuroPersoneli() {
        super();
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
