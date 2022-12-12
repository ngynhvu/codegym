package com.example.furamamanagerment.service.user;

import com.example.furamamanagerment.model.user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void update(User user);
    User findByUsername(String username);

}
