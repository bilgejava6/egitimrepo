package com.aliakkulah.repository;

import java.util.List;

public interface ICrud<T> {
    public void save(T t);
    public void update (T t);
    public void delete (T t);
    public List<T> findAll ();
    public T findById(Long id);
    public void deleteById(Long id);
}