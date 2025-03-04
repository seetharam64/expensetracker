package com.example.expensetracker.signup.service;

import com.example.expensetracker.signup.entity.User;
import com.example.expensetracker.signup.repository.UserRepository;
import com.example.expensetracker.signup.requestdto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<String> duplicateUserMsg(UserRequestDTO userinfo){
        User userentity = new User();
        Optional<User> exiusr = userRepository.findByUsername(userinfo.getUsername());
        Optional<User> exiemail = userRepository.findByEmail(userinfo.getEmail());
        if (exiusr.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username exists. Please choose a different name.");
        }else if (exiemail.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists login with your credentials.");
        }else {
            userentity.setUsername(userinfo.getUsername());
            userentity.setEmail(userinfo.getEmail());
            String hashPassword = passwordEncoder.encode(userinfo.getPassword());
            userentity.setPassword(hashPassword);
            userRepository.save(userentity);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User account created successfully!");

    }




}
