package com.jacup101.yelp.repository;

import java.math.BigDecimal;
import java.util.List;

import com.jacup101.yelp.model.Address;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Hours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusinessRepository extends JpaRepository<Business, String> {
    // pass in type and type for the primary key to access type

    List<Business> findByBusinessId(String businessId);
    

    @Query("SELECT b FROM Business b WHERE b.name LIKE %?1%"
    + " OR b.category LIKE %?1%")
    List<Business> search(String keyword);


    @Query("SELECT a FROM Address a WHERE a.businessId = ?1")
    List<Address> findAddress(String id);

    @Query("SELECT h FROM Hours h WHERE h.businessId = ?1")
    List<Hours> findHours(String id);

    @Query("SELECT b FROM Business b WHERE b.stars = ?1")
    List<Business> starsEquals(BigDecimal stars);
    @Query("SELECT b FROM Business b WHERE b.stars <= ?1")
    List<Business> starsLess(BigDecimal stars);
    @Query("SELECT b FROM Business b WHERE b.stars >= ?1")
    List<Business> starsGreater(BigDecimal stars);
}
