package com.project.SpringBoot.controller;

import com.project.SpringBoot.model.Users;
import com.project.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users createUser(@RequestBody Users user){
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return service.verify(users);
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return service.getAllUsers();
    }
}
