package com.beratacer.repository.entity;

public class BuroPersoneli extends Personel{
    private String excelBilgisi;

    public BuroPersoneli(String adSoyad, String telNo, String tcNo, String adres,
                         Departman departman, String iseBaslamaTarihi,  String excelBilgisi) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);

        this.excelBilgisi = excelBilgisi;
    }



    public String getExcelBilgisi() {
        return excelBilgisi;
    }

    public void setExcelBilgisi(String excelBilgisi) {
        this.excelBilgisi = excelBilgisi;
    }

    @Override
    public String toString() {

        return super.toString()+
                "excelBilgisi='" + excelBilgisi + '\'' +
                '}';
    }
}
