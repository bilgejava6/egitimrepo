package com.beratacer.repository.entity;

public class GenelMudur extends Personel{
    private String uzmanlikAlani;

    public GenelMudur(String adSoyad, String telNo, String tcNo, String adres,
                      Departman departman, String iseBaslamaTarihi, String uzmanlikAlani) {
        super(adSoyad, telNo, tcNo, adres, departman, iseBaslamaTarihi);
        this.uzmanlikAlani = uzmanlikAlani;
    }

    public String getUzmanlikAlani() {
        return uzmanlikAlani;
    }

    public void setUzmanlikAlani(String uzmanlikAlani) {
        this.uzmanlikAlani = uzmanlikAlani;
    }

    @Override
    public String toString() {
        return super.toString() +
                "uzmanlikAlani='" + uzmanlikAlani + '\'' +
                '}';
    }
}
