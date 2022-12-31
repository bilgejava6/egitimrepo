package com.beratacer.service;

import com.beratacer.repository.DepartmanRepository;
import com.beratacer.repository.entity.Departman;
import com.beratacer.repository.entity.Personel;

import java.util.*;
import java.util.stream.Collectors;

public class DepartmanService {
    private final DepartmanRepository departmanRepository;
    private final PersonelService personelService;

    public DepartmanService() {
        this.departmanRepository=new DepartmanRepository();
        this.personelService=new PersonelService();
    }
    public void save(Departman newDepartman){
        Departman depertman=findByName(newDepartman.getAd());
        if (depertman==null){
            departmanRepository.save(newDepartman);
            System.out.println("Departman kaydi basarili bir sekilde olusturuldu..");
        }else{
            System.out.println("Departman kaydi zaten mevcut..!");
        }

    }
    public void update(Long id,Departman departman){
        Optional<Departman> optionalDepartman=departmanRepository.findById(id);
        optionalDepartman.ifPresentOrElse(d->{
            departmanRepository.update(id,departman);
        },()->{
            System.out.println("Lutfen gecerli bir id giriniz...");
        });
    }

    public List<Departman> findAll(){
        return departmanRepository.findAll();
    }
    public Departman findById(Long id){
        return departmanRepository.findById(id).orElse(null);
    }
    public Departman findByName(String name){
        return departmanRepository.findByName(name).orElse(null);
    }
    public void deleteById(Long id){
        Optional<Departman> optionalDepartman=departmanRepository.findById(id);
        optionalDepartman.ifPresentOrElse(d->{
            departmanRepository.deleteById(id);
        },()->{
            System.out.println("Lutfen gecerli bir id giriniz..");
        });
    }
    public Map<Departman,List<Personel>> getDepartmanPersonelListesi() {
        Map<Departman,List<Personel>> departmanPersonelListesi=personelService.findAll().stream()
                .collect(Collectors.groupingBy(Personel::getDepartman));
        return departmanPersonelListesi;
    }
    public Departman getEnCokPersonelliDepartman(){
        Departman encokPersonelBulunduranDepartman=getDepartmanPersonelListesi().entrySet().stream()
                .max(Map.Entry.comparingByValue((o1,o2)-> Integer.compare(o1.size(), o2.size())))
                .map(Map.Entry::getKey).orElse(null);
        return encokPersonelBulunduranDepartman;
    }
    public Map<Departman,Double> getDepartmanlaraGoreMaasOrtalamasi(){
        Map<Departman,Double> departmanlaraGoreMaasOrtalamasi=getDepartmanPersonelListesi().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,y-> y.getValue().stream()
                        .mapToDouble(k-> k.getMaas()).average().orElse(0)));
        return departmanlaraGoreMaasOrtalamasi;
    }
}
