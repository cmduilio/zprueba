package com.samit.dao;

import java.util.List;

public interface Dao<T> {

	public void add(T t);
	public void update(T t);
	public List<T> getList();
	public T getById(Long id);
	public void remove(int id);
}
