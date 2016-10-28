package com.trendit.service;

import com.trendit.model.User;
import com.trendit.repository.*;
import com.trendit.service.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
/**
 * Created by anusha on 10/25/2016.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
 //   private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user)
    {
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
}
