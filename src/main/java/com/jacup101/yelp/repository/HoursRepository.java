package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Hours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface HoursRepository extends JpaRepository<Hours, String> {
    // pass in type and type for the primary key to access type 


    List<Hours> findByBusinessId(String businessId);

    @Query("SELECT b from Business b WHERE b.businessId = ?1")
    List<Business> findBusinessByBusinessId(String businessId);

    @Modifying
    @Query("UPDATE Hours SET monday = ?1, tuesday = ?2, wednesday = ?3, thursday = ?4, friday = ?5, saturday = ?6, sunday = ?7 WHERE businessId = ?8")
    void setHours(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String businessId);


}
