package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.Entry;
import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.entity.User;
import com.wecan.sportsforumapi.repository.EntryRepository;
import com.wecan.sportsforumapi.repository.TitleRepository;
import com.wecan.sportsforumapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EntryServiceImpl implements EntryService {
    EntryRepository repository;
    UserRepository userRepository;

    TitleRepository titleRepository;
    public EntryServiceImpl(EntryRepository repository, UserRepository userRepository, TitleRepository titleRepository) {
        this.repository = repository; this.userRepository = userRepository; this.titleRepository = titleRepository;
    }

    @Override
    public Entry getEntryById(int theId) {
        Optional<Entry> entry =  repository.findById(theId);
        if(entry.isPresent())
            return entry.get();
        return null;
    }

    @Override
    public List<Entry> getAllEntries() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity save(Entry entry) {
        Entry e = repository.save(entry);
        User user = userRepository.findById(entry.getUser().getUserId());
        Title title = titleRepository.findById(entry.getTitle().gettId());
        title.setEntries(null);
        e.setUser(user);
        e.setTitle(title);
        return new ResponseEntity(e,HttpStatus.OK);
    }

    @Override
    public int likeEntry(int id) {
        return getAndChangeAnEntry(id,+1);

    }

    @Override
    public int unlikeEntry(int id) {
        return getAndChangeAnEntry(id,-1);
    }

    public int getAndChangeAnEntry(int id, int one){
        Entry entry = repository.findByeId(id);
        int newNoOfLike = entry.getNoOfLiked() + one;
        entry.setNoOfLiked(newNoOfLike);
        repository.save(entry);
        return newNoOfLike;
    }
}
