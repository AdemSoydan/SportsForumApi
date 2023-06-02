package com.wecan.sportsforumapi.repository;

import com.wecan.sportsforumapi.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EntryRepository extends JpaRepository<Entry,Integer> {
    public Entry findByeId(int id);
}
