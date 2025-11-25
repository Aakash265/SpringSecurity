package com.example.springSecurity.SpringSecurity.service;

import com.example.springSecurity.SpringSecurity.entity.User;
import com.example.springSecurity.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Iterable<User> getAllUsers() {
        return repo.findAll();
    }

    public User setUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        return repo.save(user);
    }

    public User getByUsername(String userName) {
        return repo.findByUsername(userName);
    }

    public void deleteByUsername(String username) {
        repo.deleteByUsername(username);
    }
}
