package com.wecan.footballapp.repository;

import com.wecan.footballapp.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry,Integer> {
}
