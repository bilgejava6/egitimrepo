package com.yavuzavci.repository;

import com.yavuzavci.entity.Personel;

import java.util.List;

import static com.yavuzavci.utility.StaticValues.PERSONEL_LISTESI;

/**
 * Personel verilerinin sisteme işlendiği katman.
 */
public class PersonelRepository implements ICrud<Personel> {

    public PersonelRepository(){

    }

    @Override
    public void save(Personel personel) {
        PERSONEL_LISTESI.add(personel);
        personel.getDepartman().getPersonelListesi().add(personel);
    }

    @Override
    public void update(Personel personel) {
        for(int i = 0; i < PERSONEL_LISTESI.size(); i++) {
            if(PERSONEL_LISTESI.get(i).getId().equals(personel.getId())){
                PERSONEL_LISTESI.set(i,personel);
                personel.getDepartman()
                        .getPersonelListesi()
                        .set(
                                personel.getDepartman().getPersonelListesi().indexOf(personel),
                                personel);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for(int i = 0; i < PERSONEL_LISTESI.size(); i++) {
            if(PERSONEL_LISTESI.get(i).getId().equals(id)){
                PERSONEL_LISTESI.remove(i);
                PERSONEL_LISTESI.get(i).getDepartman()
                        .getPersonelListesi()
                        .remove(PERSONEL_LISTESI.get(i));
                break;
            }
        }
    }

    @Override
    public List<Personel> findAll() {
        return PERSONEL_LISTESI;
    }

    @Override
    public Personel findById(Long id) {
        for(int i = 0; i< PERSONEL_LISTESI.size(); i++) {
            if(PERSONEL_LISTESI.get(i).getId().equals(id))
                return PERSONEL_LISTESI.get(i);
        }
        return null;
    }
}
