package com.example.adapter.controller;


import jakarta.validation.Valid;
import org.example.entity.User;
import org.example.port.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    ResponseEntity<String> createUser(@Valid @RequestBody User user){

        userService.createUser(user.getName());

        return ResponseEntity.ok("User created");
    }
}
