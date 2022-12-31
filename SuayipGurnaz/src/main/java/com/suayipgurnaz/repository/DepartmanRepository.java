package com.suayipgurnaz.repository;

import com.suayipgurnaz.repository.entity.Departman;

import java.util.List;

import static com.suayipgurnaz.utility.PtsUtility.departmanList;

public class DepartmanRepository implements ICrud<Departman>{

    @Override
    public void save(Departman d) {
        departmanList.add(d);
    }
    @Override
    public void update(Departman d) {
        for (int i = 0; i < departmanList.size(); i++) {
            if(departmanList.get(i).getId().equals(d.getId())) {
                departmanList.set(i, d);
                break;
            }
        }
    }
    @Override
    public void delete(Long id) {
        for (int i = 0; i < departmanList.size(); i++) {
            if(departmanList.get(i).getId().equals(id)){
                departmanList.remove(i);
                break;
            }
        }
    }
    @Override
    public List<Departman> findAll() {
        return departmanList;
    }
    @Override
    public Departman findById(Long id) {
        for (int i = 0; i < departmanList.size(); i++) {
            if(departmanList.get(i).getId().equals(id)) {
                return departmanList.get(i);
            }
        }
        return null;
    }
}
