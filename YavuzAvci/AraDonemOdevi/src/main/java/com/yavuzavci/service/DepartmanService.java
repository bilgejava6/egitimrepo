package com.yavuzavci.service;

import com.yavuzavci.entity.Departman;
import com.yavuzavci.repository.DepartmanRepository;

import java.util.List;
import java.util.Objects;

import static com.yavuzavci.utility.DepartmanUtility.adaGoreDepartmanBul;

/**
 * Departman verilerinin sisteme işlenmeden önce
 * denetlendiği katman.
 */
public class DepartmanService {
    private final DepartmanRepository departmanRepository;

    public DepartmanService() {
        this.departmanRepository = new DepartmanRepository();
    }
    public void save(Departman departman){
        if(!Objects.isNull(adaGoreDepartmanBul(departman.getAd()))){
            System.out.println("HATA: Sistemde aynı ada sahip bir departman kaydı vardır.");
            System.out.println("Departman numarası -> " + adaGoreDepartmanBul(departman.getAd()).getId());
            return;
        }
        departmanRepository.save(departman);
    }
    public void update(Departman departman){
        if(departmanRepository.findAll().isEmpty()){
            System.out.println("HATA: Sistemde kayıtlı departman yoktur. Güncelleme yapılamaz.");
            return;
        }
        // Özel ID li departmanlar değişmeyecektir. bkz. StaticValues.init() methodu
        if(departman.getId() == -2 || departman.getId() == -1 || departman.getId() == 0){
            System.out.println("HATA: Sistem departmanları güncellenemez.");
            return;
        }
        if(!Objects.isNull(adaGoreDepartmanBul(departman.getAd()))){
            System.out.println("HATA: Sistemde aynı ada sahip bir departman kaydı vardır.");
            System.out.println("Departman numarası -> " + adaGoreDepartmanBul(departman.getAd()).getId());
            return;
        }
        departmanRepository.update(departman);
    }
    public void delete(Long id) {
        if(departmanRepository.findAll().isEmpty()){
            System.out.println("HATA: Sistemde kayıtlı departman yoktur. Silme işlemi yapılamaz.");
            return;
        }
        // Özel ID li departmanlar değişmeyecektir. bkz. StaticValues.init() methodu
        if(id == -2 || id == -1 || id == 0){
            System.out.println("HATA: Sistem departmanları silinemez.");
            return;
        }
        departmanRepository.delete(id);
    }
    public Departman findById(Long id){
        return departmanRepository.findById(id);
    }
    public List<Departman> findAll() {
        return departmanRepository.findAll();
    }
}
