package com.trendit.service;

import com.trendit.model.User;
/**
 * Created by anush on 10/25/2016.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
