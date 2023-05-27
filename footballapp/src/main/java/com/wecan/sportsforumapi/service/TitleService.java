package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Title;

import java.util.List;

public interface TitleService {
    Title findById(int id);
    List<Title> getAllTitles();

    boolean save(Title title);
}
