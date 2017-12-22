package com.samit.service;

import com.samit.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
