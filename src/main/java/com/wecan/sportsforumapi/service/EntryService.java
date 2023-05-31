package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Entry;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EntryService {

    Entry getEntryById(int id);
    List<Entry> getAllEntries();

    ResponseEntity save(Entry entry);

}
