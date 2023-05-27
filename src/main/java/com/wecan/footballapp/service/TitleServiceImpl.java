package com.wecan.footballapp.service;

import com.wecan.footballapp.entity.Title;
import com.wecan.footballapp.repository.TitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleServiceImpl implements TitleService {
    TitleRepository repository;

    public TitleServiceImpl(TitleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Title findById(int id) {
        Optional<Title> optionalTitle = repository.findById(id);
        if(optionalTitle.isPresent())
            return optionalTitle.get();
        return null;
    }



    @Override
    public List<Title> getAllTitles() {
        return repository.findAll();
    }

    @Override
    public boolean save(Title title) {
        repository.save(title);
        return true;
    }
}
