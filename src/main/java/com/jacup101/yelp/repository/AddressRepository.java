package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.Address;
import com.jacup101.yelp.model.Business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface AddressRepository extends JpaRepository<Address, String> {
    // pass in type and type for the primary key to access type 


    List<Address> findByBusinessId(String businessId);

    @Query("SELECT b from Business b WHERE b.businessId = ?1")
    List<Business> findBusinessByBusinessId(String businessId);

    @Modifying
    @Query("UPDATE Address SET street = ?1, city = ?2, state = ?3, zip = ?4 WHERE businessId = ?5")
    void setAddress(String street, String city, String state, String zip, String businessId);



}
