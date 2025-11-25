package com.example.springSecurity.SpringSecurity.controller;

import com.example.springSecurity.SpringSecurity.entity.Journal;
import com.example.springSecurity.SpringSecurity.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> getAllJournalEntries() {
        return new ResponseEntity<>(journalService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/createJournal")
    public ResponseEntity<?> saveJournalEntries(@RequestBody Journal journalEntry) {
        journalService.saveJournal(journalEntry);
        return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
    }
}
