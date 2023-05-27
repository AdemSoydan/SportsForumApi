package com.wecan.footballapp.repository;

import com.wecan.footballapp.entity.Title;
import com.wecan.footballapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String emails);

    User findByUserName(String username);
}
