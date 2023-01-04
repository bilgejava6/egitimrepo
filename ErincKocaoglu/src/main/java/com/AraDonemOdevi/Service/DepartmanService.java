package com.AraDonemOdevi.Service;

import com.AraDonemOdevi.Entity.Departman;
import com.AraDonemOdevi.Reposiyory.DepartmanRepository;

import java.util.List;
import java.util.Map;

public class DepartmanService {

    private DepartmanRepository departmanRepository;


    public DepartmanService() {
        super();
        this.departmanRepository = new DepartmanRepository();
    }

    public void save(Departman departman) {
        departmanRepository.save(departman);
    }

    public void save(String ad) {
        Departman departman = new Departman();
        departman.setAd(ad);

        departmanRepository.save(departman);
    }

    public List<Departman> findAll() {
        return departmanRepository.findAll();
    }

    public Long personelSayisi(Departman d)
    {
        return departmanRepository.personalSayisi(d);
    }

    public Long findByKey(String key)
    {
        return departmanRepository.findByKey(key);
    }

}
