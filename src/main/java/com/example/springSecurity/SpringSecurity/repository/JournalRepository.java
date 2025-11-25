package com.example.springSecurity.SpringSecurity.repository;

import com.example.springSecurity.SpringSecurity.entity.Journal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Integer> {
}
