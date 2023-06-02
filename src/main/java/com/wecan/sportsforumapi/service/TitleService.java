package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.entity.TitleSaveRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TitleService {
    ResponseEntity findById(int id);
    List<Title> findAll();
    ResponseEntity save(Title title);

    Title saveTitle(Title title);

    ResponseEntity saveWithEntry(TitleSaveRequest request);
}
