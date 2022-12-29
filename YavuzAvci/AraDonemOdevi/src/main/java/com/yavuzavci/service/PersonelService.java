package com.yavuzavci.service;

import com.yavuzavci.entity.*;
import com.yavuzavci.repository.PersonelRepository;
import com.yavuzavci.utility.PersonelUtility;

import java.util.List;
import java.util.Objects;

import static com.yavuzavci.utility.PersonelUtility.*;

/**
 * Personel verilerinin sisteme işlenmeden önce
 * denetlendiği katman.
 */
public class PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelService() {
        this.personelRepository = new PersonelRepository();
    }
    public void save(Personel personel){
        if(personel.getAdSoyad().isEmpty())
            System.out.println("HATA: Personelin ad-soyad bilgisi boş bırakılamaz.");
        else if(Objects.isNull(personel.getCinsiyet()))
            System.out.println("HATA: Personelin cinsiyet bilgisi boş bırakılamaz.");
        else if(Objects.isNull(personel.getYas()))
            System.out.println("HATA: Personelin yaşı boş bırakılamaz.");
        else if(personel.getYas() < 18)
            System.out.println("HATA: Personelin yaşı on sekizden küçük olamaz.");
        else if(Objects.isNull(personel.getDepartman()))
            System.out.println("HATA: Personelin departman bilgisi boş bırakılamaz.");
        else
            personelRepository.save(personel);
    }
    public void update(Personel personel){
        if(personel.getAdSoyad().isEmpty())
            System.out.println("HATA: Personelin ad-soyad bilgisi boş bırakılamaz.");
        else if(Objects.isNull(personel.getCinsiyet()))
            System.out.println("HATA: Personelin cinsiyet bilgisi boş bırakılamaz.");
        else if(Objects.isNull(personel.getYas()))
            System.out.println("HATA: Personelin yaşı boş bırakılamaz.");
        else if(personel.getYas() < 18)
            System.out.println("HATA: Personelin yaşı on sekizden küçük olamaz.");
        else if(Objects.isNull(personel.getDepartman()))
            System.out.println("HATA: Personelin departman bilgisi boş bırakılamaz.");
        else{
            switch (PersonelUtility.personelTuruBelirle(personel.getClass().getSimpleName())){
                /**
                 * Aksi belirtilmedikçe büro personeli ve genel müdürler için ilave
                 * bilgi girişi yapılmayacaktır. Doğrudan güncelleme servisi işlemi
                 * çağrılabilir. Eğer büro personellerinin ve genel müdürün farklı
                 * bilgileri güncellenmek isteniyorsa {@code BuroPersoneli} ve
                 * {@code GenelMudur} sınıfları ile bu switch işlemi değiştirilmelidir.
                 */
                case 1,2: {
                    personelRepository.update(personel);
                    break;
                }
                case 3:{
                    if(((Hizmetli) personel).getVardiyaSuresi() <= 0){
                        System.out.println("HATA: Vardiya süresi sıfırdan küçük olamaz.");
                        break;
                    }
                    if(((Hizmetli) personel).getVardiyaSuresi() <= 4){
                        System.out.println("HATA: Hizmetli personellerin aylık en az 4 saat vardiyası olmalıdır.");
                        break;
                    }
                    personelRepository.update(personel);
                    break;
                }
                case 4:{
                    boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                    personel.setMaasTanimlayabilirMi(maasTanimlayabilirMi);
                    personelRepository.update(personel);
                    break;
                }
                case 5:{
                    boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                    boolean istenCikarabilirMi = istenCikarmaYetkisiAl();
                    personel.setMaasTanimlayabilirMi(maasTanimlayabilirMi);
                    personel.setIstenCikarabilirMi(istenCikarabilirMi);
                    personelRepository.update(personel);
                    break;
                }
                case 6:{
                    boolean odemeyeYetkiliMi = odemeYetkisiAl();
                    boolean maasTanimlayabilirMi = maasTanimlamaYetkisiAl();
                    personel.setOdemeyeYetkiliMi(odemeyeYetkiliMi);
                    personel.setMaasTanimlayabilirMi(maasTanimlayabilirMi);
                    personelRepository.update(personel);
                    break;
                }
                case 7:{
                    if(((TeknikPersonel) personel).getVardiyaSuresi() <= 0){
                        System.out.println("HATA: Vardiya süresi sıfırdan küçük olamaz.");
                        break;
                    }
                    if(((TeknikPersonel) personel).getVardiyaSuresi() <= 8){
                        System.out.println("HATA: Teknik personellerin aylık en az 8 saat vardiyası olmalıdır.");
                        break;
                    }
                    if(((TeknikPersonel) personel).getTeknikAlan().isEmpty()){
                        System.out.println("HATA: Teknik personelin alanı boş bırakılamaz.");
                        break;
                    }
                    personelRepository.update(personel);
                    break;
                }
                default:{
                    System.out.println("HATA: Yanlış personel türü seçtiniz.");
                    System.out.println("İşlem başarısız.");
                    break;
                }
            }
        }
    }
    public void delete(Long id) {
        if (Objects.isNull(personelRepository.findById(id))) {
            System.out.println("HATA: Silmek istediğiniz personel sistemde kayıtlı değildir.");
            return;
        }

        if (personelRepository.findById(id) instanceof GenelMudur) {
            System.out.println("HATA: Genel müdür sistemden silinemez.");
            return;
        }

        if (!(personelRepository.findById(id) instanceof Mudur)
                ||
                !personelRepository.findById(id).isIstenCikarabilirMi()) {
            System.out.println("HATA: Sistemden silme yetkiniz yoktur.");
            return;
        }

        personelRepository.delete(id);
    }
    public Personel findById(Long id){
        return personelRepository.findById(id);
    }
    public List<Personel> findAll() {
        return personelRepository.findAll();
    }
}
