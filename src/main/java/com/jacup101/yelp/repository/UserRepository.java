package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // pass in type and type for the primary key to access type 


    List<User> findByUserId(String userId);

}
