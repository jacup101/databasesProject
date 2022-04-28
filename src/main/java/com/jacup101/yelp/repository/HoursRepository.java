package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Hours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HoursRepository extends JpaRepository<Hours, String> {
    // pass in type and type for the primary key to access type 


    List<Hours> findByBusinessId(String businessId);

    @Query("SELECT b from Business b WHERE b.businessId = ?1")
    List<Business> findBusinessByBusinessId(String businessId);


}
