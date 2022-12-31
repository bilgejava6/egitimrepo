package com.beratacer.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
    void save(T t);
    void update(Long id,T t);
    List<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
}
