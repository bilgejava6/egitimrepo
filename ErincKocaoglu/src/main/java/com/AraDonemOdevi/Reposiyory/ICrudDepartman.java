package com.AraDonemOdevi.Reposiyory;

import com.AraDonemOdevi.Entity.Departman;

import java.util.List;
import java.util.Map;

public interface ICrudDepartman<D> {

    void save(D d);

    List<Departman> findAll();

    Map<Departman, Long> findAllWithCount();

    public Long personalSayisi(Departman d);

    public Long findByKey(String key);

    public Double maasOrtalamasi(Departman d);


}