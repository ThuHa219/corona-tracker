package edu.hanu.dao;

import java.util.List;

public interface Dao<T> {
	
	T get(long id);
	
	List<T> getAll();
	
	long save(T t);
	
	void update(T t);
	
	void delete(long id);
	
	void deleteAll();
	
}
