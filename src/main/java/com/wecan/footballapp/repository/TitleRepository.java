package com.wecan.footballapp.repository;

import com.wecan.footballapp.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Integer> {
}
