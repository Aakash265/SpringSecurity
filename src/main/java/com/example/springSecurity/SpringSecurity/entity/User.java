package com.example.springSecurity.SpringSecurity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;
    private String email;
    @OneToMany
    private List<Journal> journalEntries = new ArrayList<>();

    private List<String> roles;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Journal> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<Journal> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
