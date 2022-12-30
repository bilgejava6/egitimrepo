package com.aliakkulah.repository;

import java.util.List;
import java.util.Map;

public interface ICrud<T> {
    public void save(T t);
    public void update (T t);
    public void delete (T t);
    public List<T> findAll ();
    public void findById(Long id);
    public void deleteById(Long id);
    public Map<String,Double> odemeListesi();
}