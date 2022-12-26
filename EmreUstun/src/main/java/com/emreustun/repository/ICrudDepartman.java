package com.emreustun.repository;
import java.util.List;
import java.util.Set;

public interface ICrudDepartman<T> {
    void save(T departman);
    List<T> findAll();


}
