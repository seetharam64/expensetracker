package com.example.expensetracker.signup.controller;

import com.example.expensetracker.signup.requestdto.UserRequestDTO;
import com.example.expensetracker.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/signup")
public class AuthController {

    @Autowired
    UserService userService;


    @PostMapping("/registeruser")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO user){
        return userService.duplicateUserMsg(user);
    }


}
