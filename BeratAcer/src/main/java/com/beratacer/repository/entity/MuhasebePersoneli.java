package com.beratacer.repository.entity;

public class MuhasebePersoneli extends Personel{
    private String programBilgisi;

    public MuhasebePersoneli(String adSoyad, String telNo, String tcNo, String adres,
                             Departman departman, String iseBaslamaTarihi, String programBilgisi) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);
        this.programBilgisi = programBilgisi;
    }

    public String getProgramBilgisi() {
        return programBilgisi;
    }

    public void setProgramBilgisi(String programBilgisi) {
        this.programBilgisi = programBilgisi;
    }

    @Override
    public String toString() {
        return super.toString() +
                "programBilgisi='" + programBilgisi + '\'' +
                '}';
    }
}
