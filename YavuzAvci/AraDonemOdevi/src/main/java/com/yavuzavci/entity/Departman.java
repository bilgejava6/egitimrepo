package com.yavuzavci.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Personellerin departmanlarının tutulduğu temel sınıf.
 * <br>
 * <br>
 * Her personelin mutlaka bir departmanı olup, her departmanda
 * bulunan personeller kendi içlerinde ayrı bir listede tutulmaktadır.
 * <br>
 * <br>
 * Aktif olmayan personeller, departmanı başta tanımlanmayan veya
 * hiç departmanı olmayan personeller ve genel müdür dahil
 * sistemde kayıtlı bütün müdürler için uygulama başlatılırken
 * özel numaralı departmanlar oluşturulmaktadır.
 * <br>
 * <br>
 * Normal departmanlar sıfırdan büyük numaralarla başlamaktadır.
 * Ayrıntı için {@code StaticValues} sınıfına bakınız.
 *
 * @author Yavuz AVCI
 */
public class Departman extends BaseEntity {
    private String ad;
    private List<Personel> personelListesi;

    public Departman(String ad){
        super();
        this.ad = ad;
        personelListesi = new ArrayList<>();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public List<Personel> getPersonelListesi() {
        return personelListesi;
    }

    public void setPersonelListesi(List<Personel> personelListesi) {
        this.personelListesi = personelListesi;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "ad='" + ad + '\'' +
                ", calisanSayisi=" + personelListesi.size() +
                '}';
    }
}
