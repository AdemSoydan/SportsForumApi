package com.wecan.footballapp.rest;

import com.wecan.footballapp.entity.Title;
import com.wecan.footballapp.entity.User;
import com.wecan.footballapp.repository.TitleRepository;
import com.wecan.footballapp.repository.UserRepository;
import com.wecan.footballapp.service.TitleService;
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
