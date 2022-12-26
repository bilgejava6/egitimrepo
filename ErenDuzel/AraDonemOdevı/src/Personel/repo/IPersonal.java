package Personel.repo;

import java.util.List;

public interface IPersonal<T> {

	void save(T t);
    void update(T t);
    void delete(Long id);
    T findById(Long id);
    List<T> findAll();

	
}
