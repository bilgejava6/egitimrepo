package com.emreustun.service;

import com.emreustun.entity.Departman;
import com.emreustun.repository.DepartmanRepository;
import com.emreustun.utility.StaticValues;

import java.util.List;
import java.util.Set;

public class DepartmanService {
    DepartmanRepository departmanRepository;

    public DepartmanService() {
        this.departmanRepository = new DepartmanRepository();
    }

    public void save(Departman departman) {
        boolean varMi = false;
        for (Departman depo : StaticValues.departmanListesi) {
            if (depo.getAd().toLowerCase().equals(departman.getAd().toLowerCase())) {
                varMi = true;
            } else {
                varMi = false;
            }
        }
        if (departman.getVardiyaSayisi() < 1 || departman.getVardiyaSayisi() > 3) {
            System.err.println("departman vardiya sayisi 0 veya 3'ten büyük olamaz.");
            System.err.println("departman eklenemedi");
        } else if (varMi) {
            System.err.println("Daha önce bu isimde departman girilmiş. Kayıt iptal edildi");
        } else
            departmanRepository.save(departman);
    }

    public List<Departman> findAll() {
        return departmanRepository.findAll();
    }
}
