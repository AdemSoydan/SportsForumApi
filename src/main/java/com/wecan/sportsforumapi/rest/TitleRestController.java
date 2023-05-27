package com.wecan.sportsforumapi.rest;

import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.repository.TitleRepository;
import com.wecan.sportsforumapi.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TitleRestController {

    TitleRepository repository;


    public TitleRestController(TitleRepository repository,UserRepository userRepository) {
        this.repository = repository;
    }

    @GetMapping("/title")
    List<Title> getAllTitles(){
        return repository.findAll();
    }


/*TitleService service;
    public TitleRestController(TitleService service) {
        this.service = service;
    }

    @GetMapping("/title")
    List<Title> getAllTitles(){
        return service.getAllTitles();
    }*/

}
