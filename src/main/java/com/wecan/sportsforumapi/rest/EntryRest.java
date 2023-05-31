package com.wecan.sportsforumapi.rest;

import com.wecan.sportsforumapi.entity.Entry;
import com.wecan.sportsforumapi.service.EntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntryRest {
    EntryService service;

    public EntryRest(EntryService service) {
        this.service = service;
    }

    @PostMapping("/entry")
    public ResponseEntity saveEntry(@RequestBody Entry entry){
        return service.save(entry);
    }

    @GetMapping("/entries")
    public List<Entry> getEntries(@RequestBody Entry entry){
       return service.getAllEntries();
    }
}
