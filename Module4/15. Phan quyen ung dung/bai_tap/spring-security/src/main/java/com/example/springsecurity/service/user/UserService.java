package com.example.springsecurity.service.user;


import com.example.springsecurity.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
