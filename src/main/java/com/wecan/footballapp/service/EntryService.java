package com.wecan.footballapp.service;

import com.wecan.footballapp.entity.Entry;
import com.wecan.footballapp.repository.EntryRepository;

import java.util.List;

public interface EntryService {

    Entry getEntryById(int id);
    List<Entry> getAllEntries();

    void save(Entry entry);

}
