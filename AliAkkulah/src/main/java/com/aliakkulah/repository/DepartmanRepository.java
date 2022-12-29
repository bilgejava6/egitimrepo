package com.aliakkulah.repository;

import com.aliakkulah.entity.Departman;
import static com.aliakkulah.utility.Utility.*;

import java.util.List;

public class DepartmanRepository {

    public void save(Departman departman) {
        departmanListesi.add(departman);
    }

    public List<Departman> findAll() {
        return departmanListesi;
    }
}