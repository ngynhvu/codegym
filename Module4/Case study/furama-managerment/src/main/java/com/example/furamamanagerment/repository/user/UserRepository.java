package com.example.furamamanagerment.repository.user;

import com.example.furamamanagerment.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
