package com.aliulas.repository.entity;

public class MuhasebePersoneli extends Personel {
    private double maasEkle;

    public MuhasebePersoneli() {
        super();

    }

    public MuhasebePersoneli(String ad, String soyad, String email, String telefon, String pozisyon, int maas, String kayitTarihi, double maasEkle,String departman) {
        super(ad, soyad, email, telefon, pozisyon, maas, kayitTarihi,departman);
        this.maasEkle = maasEkle;
    }

    public double getMaasEkle() {
        return maasEkle;
    }

    public void setMaasEkle(double maasEkle) {
        this.maasEkle = maasEkle;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli{" +
                "maasEkle=" + maasEkle +
                "} " + super.toString();
    }

}
