package com.aliakkulah.service;

import com.aliakkulah.entity.Departman;
import com.aliakkulah.repository.DepartmanRepository;

public class DepartmanService {
    private final DepartmanRepository dr;

    public DepartmanService() {dr = new DepartmanRepository();}

    public void save(Departman departman) {
        dr.save(departman);
    }
}