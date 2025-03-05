package com.example.expensetracker.login.service;

import com.example.expensetracker.login.repository.UserLoginRepository;
import com.example.expensetracker.signup.entity.User;
import com.example.expensetracker.signup.requestdto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<String> authenticateUser(UserRequestDTO userinfo){
        User userentity = new User();
        User exiusr = userLoginRepository.findByUsername(userinfo.getUsername());
        boolean matchPassword = bCryptPasswordEncoder.matches(userinfo.getPassword(), exiusr.getPassword());
        if (matchPassword){
            return ResponseEntity.status(HttpStatus.OK).body("Details verified!");
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Please enter correct password.");
        }

    }

}
