package com.trendit.repository;

import com.trendit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by anush on 10/25/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
        }