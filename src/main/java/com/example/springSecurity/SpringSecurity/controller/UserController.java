package com.example.springSecurity.SpringSecurity.controller;

import com.example.springSecurity.SpringSecurity.entity.User;
import com.example.springSecurity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/view-all")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String userName) {
        return new ResponseEntity<>(userService.getByUsername(userName), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDB = userService.getByUsername(username);
        userInDB.setUsername(user.getUsername());
        userInDB.setPassword(user.getPassword());
        userService.setUser(userInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.deleteByUsername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
