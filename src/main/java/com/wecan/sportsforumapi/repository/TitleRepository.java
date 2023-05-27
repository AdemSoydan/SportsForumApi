package com.wecan.sportsforumapi.repository;

import com.wecan.sportsforumapi.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Integer> {
}
