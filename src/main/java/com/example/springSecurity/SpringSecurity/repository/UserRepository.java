package com.example.springSecurity.SpringSecurity.repository;

import com.example.springSecurity.SpringSecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    void deleteByUsername(String name);
}
