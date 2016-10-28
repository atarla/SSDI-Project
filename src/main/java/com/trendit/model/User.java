package com.trendit.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by anusha on 10/25/2016.
 */

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String password_confirm;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return password_confirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.password_confirm = passwordConfirm;
    }
}

