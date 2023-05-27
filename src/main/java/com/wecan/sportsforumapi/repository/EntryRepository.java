package com.wecan.sportsforumapi.repository;

import com.wecan.sportsforumapi.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry,Integer> {
}
