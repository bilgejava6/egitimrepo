package com.AraDonemOdevi.Reposiyory;

import com.AraDonemOdevi.Entity.Departman;

import java.util.List;
import java.util.Map;

import static com.AraDonemOdevi.Utility.DepartmanUtility.departmanListesi;

public class DepartmanRepository implements ICrudDepartman<Departman> {


    @Override
    public void save(Departman d) {
        departmanListesi.add(d);

    }


    @Override
    public List<Departman> findAll() {
        return departmanListesi;
    }

    @Override
    public Map<Departman, Long> findAllWithCount() {
        return null;
    }

    @Override
    public Long personalSayisi(Departman d) {

        return 0L;//return departmanListesi.get(d);
    }

    @Override
    public Long findByKey(String key) {

        //return departmanListesi.get(key);
        return 0L;
    }

    @Override
    public Double maasOrtalamasi(Departman d) {
        return null;
    }

}
