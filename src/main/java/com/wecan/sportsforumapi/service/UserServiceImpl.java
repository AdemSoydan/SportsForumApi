package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.User;
import com.wecan.sportsforumapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByEmail(String emails) {
        return repository.findByEmail(emails);
    }


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity save(User user) {
        User u = repository.findByEmail(user.getEmail());
        if(u != null){
            return new ResponseEntity(user, HttpStatus.CONFLICT);
        }
        System.out.println();
        u = repository.findByUserName(user.getUserName());
        if(u != null){
            return new ResponseEntity(user, HttpStatus.CONFLICT);
        }
        repository.save(user);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @Override
    public ResponseEntity checkUserIsValid(User user) {
        String userName = user.getUserName();
        User dbUser = repository.findByUserName(userName);
        if(dbUser == null || !user.getPassword().equals(dbUser.getPassword()))
            return new ResponseEntity(HttpStatus.CONFLICT);

        return new ResponseEntity(dbUser, HttpStatus.OK);
    }
}
