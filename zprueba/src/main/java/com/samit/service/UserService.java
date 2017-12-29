package com.samit.service;

import com.samit.model.User;

public interface UserService extends Service<User> {

	public User getByUsername(String username);
}
