package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Entry;
import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.entity.TitleResponse;
import com.wecan.sportsforumapi.entity.TitleSaveRequest;
import com.wecan.sportsforumapi.repository.EntryRepository;
import com.wecan.sportsforumapi.repository.TitleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleServiceImpl implements TitleService {
    TitleRepository titleRepository;
    EntryRepository entryRepository;

    public TitleServiceImpl(TitleRepository repository, EntryRepository entryRepository) {
        this.titleRepository = repository;
        this.entryRepository = entryRepository;
    }

    @Override
    public ResponseEntity findById(int id) {
        Title optionalTitle = titleRepository.findById(id);
        if(optionalTitle != null)
        {
            Title dbTitle = optionalTitle;
            dbTitle.getEntries().forEach(x -> x.setTitle(null));
            dbTitle.getEntries().forEach(x -> x.getUser().setPassword(null));
            dbTitle.getEntries().forEach(x -> x.getUser().setEntries(null));
            dbTitle.getEntries().forEach(x -> x.getUser().setEmail(null));
            return new ResponseEntity(dbTitle,HttpStatus.OK);
        }

        return new ResponseEntity(optionalTitle,HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    @Override
    public ResponseEntity save(Title title) {
        Title t = titleRepository.save(title);
        return new ResponseEntity(t, HttpStatus.OK);
    }

    @Override
    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    @Override
    public ResponseEntity saveWithEntry(TitleSaveRequest request) {
        Title dbTitle = titleRepository.findById(request.getTitle().gettId());
        if(dbTitle == null){
            Title title = titleRepository.save(request.getTitle());
            Entry e = request.getEntry();
            e.setTitle(title);
            Entry dbEntry = entryRepository.save(e);
            TitleSaveRequest response = new TitleSaveRequest(request.getTitle(),e);
            return new ResponseEntity(response,HttpStatus.OK);
        }
        else{
            Entry entry = entryRepository.save(new Entry());
            return new ResponseEntity(new TitleSaveRequest(dbTitle,entry),HttpStatus.OK);
        }
    }
}
