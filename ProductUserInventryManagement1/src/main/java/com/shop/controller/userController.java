package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.userLoginDTO;
import com.shop.dto.userRegistrationDTO;
import com.shop.entity.User;
import com.shop.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class userController {
    
	@Autowired
	private UserService userService;
	

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody userRegistrationDTO dto) {
        User user = userService.registerUser(dto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody userLoginDTO dto) {
        User user = userService.loginUser(dto);
        return ResponseEntity.ok("Login successful! Welcome, " + user.getUserName());
    }
	
}
