package com.beratacer.repository.entity;

public abstract class Personel {
    private Long id;
    private String adSoyad;
    private String telNo;
    private String tcNo;
    private String adres;
    private Double maas;
    private Departman departman;
    private String iseBaslamaTarihi;

    public Personel() {
    }

    public Personel(String adSoyad, String telNo, String tcNo, String adres,Departman departman,String iseBaslamaTarihi) {
        //this.id= ++StaticValues.personelId;
        this.adSoyad = adSoyad;
        this.telNo = telNo;
        this.tcNo = tcNo;
        this.adres = adres;
        this.departman=departman;
        this.iseBaslamaTarihi=iseBaslamaTarihi;

    }

    public Long getId() {
        return id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Double getMaas() {
        return maas;
    }

    public void setMaas(Double maas) {
        this.maas = maas;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    public String getIseBaslamaTarihi() {
        return iseBaslamaTarihi;
    }

    public void setIseBaslamaTarihi(String iseBaslamaTarihi) {
        this.iseBaslamaTarihi = iseBaslamaTarihi;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", adSoyad='" + adSoyad + '\'' +
                ", telNo='" + telNo + '\'' +
                ", tcNo='" + tcNo + '\'' +
                ", adres='" + adres + '\'' +
                ", maas=" + maas +
                ", departman=" + departman +
                ", iseBaslamaTarihi='" + iseBaslamaTarihi + '\'' +
                " ";
    }
}
