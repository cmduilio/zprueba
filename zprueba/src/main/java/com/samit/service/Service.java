package com.samit.service;

import java.util.List;

public interface Service<T> {

	public void add(T p);
	public void update(T p);
	public List<T> getList();
	public T getById(Long id);
	public void remove(int id);
	
}
