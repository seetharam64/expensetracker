package com.example.expensetracker.login.controller;

import com.example.expensetracker.login.service.AuthService;
import com.example.expensetracker.signup.requestdto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/login")
public class UserLoginController {

    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody UserRequestDTO user){
        return authService.authenticateUser(user);
    }
}
