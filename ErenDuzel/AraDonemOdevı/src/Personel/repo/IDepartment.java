package Personel.repo;

import java.util.Set;

public interface IDepartment<T> {

	void save(T department);
	Set<T> findAll();
}
