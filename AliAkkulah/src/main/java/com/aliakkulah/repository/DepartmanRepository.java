package com.aliakkulah.repository;

import com.aliakkulah.entity.Departman;

import static com.aliakkulah.utility.Utility.*;

public class DepartmanRepository {

    public void save(Departman departman) {
        departmanListesi.add(departman);
    }
}