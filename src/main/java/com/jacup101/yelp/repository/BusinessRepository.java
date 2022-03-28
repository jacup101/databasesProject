package com.jacup101.yelp.repository;
import com.jacup101.yelp.model.Business;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, String> {
    // pass in type and type for the primary key to access type 
}
