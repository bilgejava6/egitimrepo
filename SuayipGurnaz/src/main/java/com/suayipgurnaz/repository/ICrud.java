package com.suayipgurnaz.repository;

import java.util.List;

public interface ICrud<T> {
        void save(T t);
        void update(T t);
        void delete(Long id);
        List<T> findAll();
        T findById(Long id);
}
