package com.volkangenel.odev.repository;

import java.util.List;

public interface ICrud <T>{
    /**
     * save,update,delete,findAll, findById, deleteById methodlarını mutlaka kullanınız.
     */

    void save (T t);
    void update (T t);
    List<T> findAll ();
    T findById (Long id);
    void deleteById (Long id);


}
