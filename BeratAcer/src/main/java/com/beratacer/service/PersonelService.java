package com.beratacer.service;

import com.beratacer.repository.PersonelRepository;
import com.beratacer.repository.entity.Departman;
import com.beratacer.repository.entity.Mudur;
import com.beratacer.repository.entity.Personel;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelService() {
        this.personelRepository=new PersonelRepository();
    }

    public void save(Personel newPersonel){
        Personel personel=findByTcNo(newPersonel.getTcNo());
        if(personel==null){
            personelRepository.save(newPersonel);
            System.out.println("Personel kaydi basarili bir sekilde olusturuldu.."+
                    "\n"+"Personeli maas ve sigorta islemleri icin Muhasebe departmanina yonlendiriniz..");

        }else{
            System.out.println("Personel kaydi zaten mevcut..!");
        }

    }
    public  void update(Long id,Personel personel){
        Optional<Personel> optionalPersonel=personelRepository.findById(id);
        optionalPersonel.ifPresentOrElse(p->{
            personelRepository.update(id,personel);

        },()->{
            System.out.println("Lutfen gecerli bir id giriniz..");
        });
    }

    public List<Personel> findAll(){
        return personelRepository.findAll();
    }
    public Personel findById(Long id){
        return personelRepository.findById(id).orElse(null);
    }
    public Personel findByTcNo(String tcNo){
        return personelRepository.findByTcNo(tcNo).orElse(null);
    }
    public void deleteById(Long id){
        Optional<Personel> optionalPersonel=personelRepository.findById(id);
        optionalPersonel.ifPresentOrElse(p->{
            personelRepository.deleteById(id);
        },()->{
            System.out.println("Lutfen gecerli bir id giriniz..");
        });

    }

    public void maasPersonelTanimlama(String tcNo, Double maas){
        Optional<Personel> optionalPersonel=personelRepository.findByTcNo(tcNo);
        optionalPersonel.ifPresentOrElse(p->{
            Personel foundPersonel=optionalPersonel.get();
            foundPersonel.setMaas(maas);
        },()->{
            System.out.println("Lutfen gecerli bir tcNo giriniz..");
        });

    }
    public Map<Long,Double> getOdemeListesi(){
        Map<Long,Double> odemeListesi=findAll().stream()
                .collect(Collectors.toMap(Personel::getId,Personel::getMaas));
        return odemeListesi;
    }
    public List<Departman> getSorumluOlunanDepartmanlar(Long id){
        Mudur mudur=(Mudur)findById(id);

        if (mudur!=null){
            return mudur.getDepartmanListesi();
        }else{
            System.out.println("Lutfen gecerli bir id giriniz..");
            return null;
        }

    }
    public Map<String,List<Personel>> getKayitTarihlerineGorePersoneller(){
        Map<String,List<Personel>> kayitTarih=findAll().stream()
                .collect(Collectors.groupingBy(Personel::getIseBaslamaTarihi));
        return kayitTarih;
    }
    public void getAyniTarihliPersoneller(){
        getKayitTarihlerineGorePersoneller().entrySet().stream()
                .filter(x-> x.getValue().size()>1).forEach(System.out::println);
    }

}
