package com.wecan.sportsforumapi.repository;

import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Integer> {
    Title findById(int id);
}
