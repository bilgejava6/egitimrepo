package com.emreustun.repository;

import java.util.List;

public interface ICrudPersonel<T> {
    void save(T t);
    void update(T t);
    void delete(Long id);
    T findById(Long id);
    List<T> findAll();

}
