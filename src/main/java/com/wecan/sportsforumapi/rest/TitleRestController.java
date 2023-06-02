package com.wecan.sportsforumapi.rest;

import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.entity.TitleResponse;
import com.wecan.sportsforumapi.entity.TitleSaveRequest;
import com.wecan.sportsforumapi.service.TitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TitleRestController {

    TitleService service;


    public TitleRestController(TitleService repository) {
        this.service = repository;
    }

    @GetMapping("/title")
    List<TitleResponse> getAllResponses(){
        List<Title> titles = service.findAll();
        List<TitleResponse> responses = new ArrayList<>();
        for(int i = 0; i < titles.size(); i++){
            Title title = titles.get(i);
            responses.add(new TitleResponse(title.getTitleName(),title.getEntries().size(), title.gettId()));
        }
        return  responses;
    }

    @GetMapping("/titles")
    List<Title> getAllTitles(){
        return service.findAll();
    }

    @PostMapping("/title")
    ResponseEntity saveTitle(@RequestBody Title title){
        return service.save(title);
    }

    @PostMapping("/titlesave")
    ResponseEntity saveTitleWithEntry(@RequestBody TitleSaveRequest request){
        return service.saveWithEntry(request);
    }

    @GetMapping("/titles/{id}")
    ResponseEntity getTitleById(@PathVariable int id){
        return service.findById(id);
    }

}
