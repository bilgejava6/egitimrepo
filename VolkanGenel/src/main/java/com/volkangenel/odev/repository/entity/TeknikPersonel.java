package com.volkangenel.odev.repository.entity;

public class TeknikPersonel extends Personel {
    public int teknikkoluno;
    String tesisno;

    public TeknikPersonel(String ad, String soyisim, String unvan, double maas, String telefon, String aciltelefon, String tckimlik, Departman departman, int teknikkoluno, String tesisno) {
        super(ad, soyisim, unvan, maas, telefon, aciltelefon, tckimlik, departman);
        this.teknikkoluno = teknikkoluno;
        this.tesisno = tesisno;
    }

    @Override
    public String toString() {
        return "TeknikPersonel{" +
                "teknikkoluno=" + teknikkoluno +
                ", tesisno='" + tesisno + '\'' +
                '}';
    }

    public int getTeknikkoluno() {
        return teknikkoluno;
    }

    public void setTeknikkoluno(int teknikkoluno) {
        this.teknikkoluno = teknikkoluno;
    }

    public String getTesisno() {
        return tesisno;
    }

    public void setTesisno(String tesisno) {
        this.tesisno = tesisno;
    }
}
