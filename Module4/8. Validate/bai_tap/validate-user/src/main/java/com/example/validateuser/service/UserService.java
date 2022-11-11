package com.example.validateuser.service;

import com.example.validateuser.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(int id);

    void save(User user);

    void remove(int id);
}
