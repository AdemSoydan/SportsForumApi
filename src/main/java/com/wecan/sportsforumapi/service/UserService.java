package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User findByEmail(String emails);

    List<User> findAll();

    ResponseEntity save(User user);

    ResponseEntity checkUserIsValid(User user);
}
