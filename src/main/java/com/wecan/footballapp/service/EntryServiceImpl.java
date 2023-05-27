package com.wecan.footballapp.service;

import com.wecan.footballapp.entity.Entry;
import com.wecan.footballapp.repository.EntryRepository;
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
    public void save(Entry entry) {
        repository.save(entry);
    }
}
