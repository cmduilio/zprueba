package com.samit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samit.dao.UserDao;
import com.samit.dao.UserDaoImpl;
import com.samit.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void add(User p) {
		this.userDao.add(p);
	}

	@Transactional
	public void update(User p) {
		this.userDao.update(p);
	}

	@Transactional
	public List<User> getList() {
		return this.userDao.getList();
	}

	@Transactional
	public User getById(Long id) {
		return this.userDao.getById(id);
	}

	@Transactional
	public void remove(int id) {
		this.userDao.remove(id);
	}
	
	@Transactional
	public User getByUsername(String username) {
		return this.userDao.getByUsername(username);
	}

}
