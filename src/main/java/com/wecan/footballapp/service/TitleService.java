package com.wecan.footballapp.service;

import com.wecan.footballapp.entity.Entry;
import com.wecan.footballapp.entity.Title;

import java.util.List;

public interface TitleService {
    Title findById(int id);
    List<Title> getAllTitles();

    boolean save(Title title);
}
