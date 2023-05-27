package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Entry;

import java.util.List;

public interface EntryService {

    Entry getEntryById(int id);
    List<Entry> getAllEntries();

    void save(Entry entry);

}
