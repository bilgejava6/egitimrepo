package com.suayipgurnaz.service;

import com.suayipgurnaz.repository.DepartmanRepository;
import com.suayipgurnaz.repository.ICrud;
import com.suayipgurnaz.repository.entity.Departman;

import java.util.List;

public class DepartmanService implements ICrud<Departman> {
    private DepartmanRepository repository;

    public DepartmanService() {
        repository = new DepartmanRepository();
    }

    @Override
    public void save(Departman departman) {
        if(departman.getAd().isEmpty())
            System.out.println("Eksik bilgi girişi, geçerli bir ad giriniz");
        else {
            repository.save(departman);
        }
    }

    @Override
    public void update(Departman departman) {
        repository.update(departman);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Departman> findAll() {
        return repository.findAll();
    }

    @Override
    public Departman findById(Long id) {
        return repository.findById(id);
    }
}
