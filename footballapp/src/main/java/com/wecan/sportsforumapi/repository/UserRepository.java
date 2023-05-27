package com.wecan.sportsforumapi.repository;

import com.wecan.sportsforumapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String emails);

    User findByUserName(String username);
}
