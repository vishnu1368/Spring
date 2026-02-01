package com.project.SpringBoot.service;

import com.project.SpringBoot.repository.UserRepo;
import com.project.SpringBoot.security.UserPrincipal;
import com.project.SpringBoot.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByName(username);
        System.out.println("Hello " + user);
        if(user == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found " + username);
        }
        return new UserPrincipal(user);
    }
}
