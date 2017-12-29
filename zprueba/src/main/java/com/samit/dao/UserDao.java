package com.samit.dao;

import com.samit.model.User;

public interface UserDao extends Dao<User> {

	public User getByUsername(String username);
}
