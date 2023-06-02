package com.wecan.sportsforumapi.rest;

import com.wecan.sportsforumapi.entity.Entry;
import com.wecan.sportsforumapi.service.EntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/likeentry/{id}")
    public int likeAnEntry(@PathVariable int id){
        return service.likeEntry(id);
    }
    @GetMapping("/unlikeentry/{id}")
    public int unlikeAnEntry(@PathVariable int id){
        return service.unlikeEntry(id);
    }
}
