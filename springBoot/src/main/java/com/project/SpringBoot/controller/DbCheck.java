package com.project.SpringBoot.controller;

import com.project.SpringBoot.repository.UserRepo;
import com.project.SpringBoot.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbCheck {
        @Autowired
        private UserRepo userrepo;

        @GetMapping("/db-check")
        public String checkDb() throws Exception {
            Users user = userrepo.findByName("Alice");
            if(user == null) System.out.println("Log - Not Found");
            else System.out.println("Log - Found" + user);
            return "Processed";
        }

}
