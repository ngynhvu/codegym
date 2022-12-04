package com.example.blog.service.user;

import com.example.blog.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
