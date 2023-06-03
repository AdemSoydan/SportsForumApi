package com.wecan.sportsforumapi.service;

import com.wecan.sportsforumapi.entity.User;
import com.wecan.sportsforumapi.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository repository;

    PasswordEncoder encoder;


    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository; this.encoder = encoder;
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
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @Override
    public ResponseEntity checkUserIsValid(User user) {
        String userName = user.getUserName();
        User dbUser = repository.findByUserName(userName);
        String passw = user.getPassword();
        if(passw != null && BCrypt.checkpw(user.getPassword(),dbUser.getPassword()))
            return new ResponseEntity(dbUser,HttpStatus.OK);

        return new ResponseEntity(user, HttpStatus.CONFLICT);
    }

}
