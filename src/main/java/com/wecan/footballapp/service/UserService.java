package com.wecan.footballapp.service;

import com.wecan.footballapp.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

public interface UserService {
    User findByEmail(String emails);

    List<User> findAll();

    ResponseEntity save(User user);

    ResponseEntity checkUserIsValid(User user);
}
