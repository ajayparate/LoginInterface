package com.loginbackend.controller;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginbackend.entity.User;
import com.loginbackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as needed
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    // public String postMethodName(@RequestBody String entity) {
    //     //TODO: process POST request
        
    //     return entity;
    // }
    
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestParam String email, @RequestParam String password, @RequestParam String name) {
        // if (userService.isEmailRegistered(user.getEmail())) {
        //     return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered");
        // }
        // if (userService.isNameRegistered(user.getName())) {
        //     return ResponseEntity.status(HttpStatus.CONFLICT).body("Name already registered");
        // }
        // User savedUser = userService.registerUser(user);
        // return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        if (userService.isEmailRegistered(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        if (userService.isNameRegistered(user.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        User savedUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        if (userService.validateUser(email, password)) {
            User user = userService.findByEmail(email);
            String token = userService.generateToken(user);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
