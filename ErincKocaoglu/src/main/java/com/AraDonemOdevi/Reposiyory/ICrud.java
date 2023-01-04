package com.AraDonemOdevi.Reposiyory;

import java.util.Map;

public interface ICrud<T> {

    void save(T t);
    void update(T t, T p);
    void delete(T t);
    Map<Long,T> findAll();
    T findById(Long id);
    void deleteById(Long id);


}
