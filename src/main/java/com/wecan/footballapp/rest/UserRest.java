package com.wecan.footballapp.rest;

import com.wecan.footballapp.entity.User;
import com.wecan.footballapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRest {
    UserService service;

    @Autowired
    public UserRest(UserService repository) {
        this.service = repository;
    }


    @PostMapping("/userlogin")
    public ResponseEntity getAllUsers(@RequestBody User user){
        System.out.println("istek geldi");
        return service.checkUserIsValid(user);
    }

    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody User user){
       return service.save(user);
    }


}
