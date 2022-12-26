package com.yavuzavci.repository;

import java.util.List;

public interface ICrud<T> {
	void save(T t);
	void update(T t);
	void delete(Long id); // deleteById
	List<T> findAll();
	T findById(Long id);
	
}
