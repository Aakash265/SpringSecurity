package com.example.springSecurity.SpringSecurity.service;

import com.example.springSecurity.SpringSecurity.entity.Journal;
import com.example.springSecurity.SpringSecurity.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepository repo;
    public Iterable<Journal> getAll() {
        return repo.findAll();
    }

    public void saveJournal(Journal journal) {
        repo.save(journal);
    }
}
