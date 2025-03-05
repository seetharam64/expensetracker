package com.example.expensetracker.login.repository;

import com.example.expensetracker.signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

}
