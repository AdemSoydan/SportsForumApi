package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Entry;
import com.wecan.sportsforumapi.repository.EntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EntryServiceImpl implements EntryService {
    EntryRepository repository;

    public EntryServiceImpl(EntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Entry getEntryById(int theId) {
        Optional<Entry> entry =  repository.findById(theId);
        if(entry.isPresent())
            return entry.get();
        return null;
    }

    @Override
    public List<Entry> getAllEntries() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity save(Entry entry) {
        Entry e = repository.save(entry);
        return new ResponseEntity(e,HttpStatus.OK);
    }
}
