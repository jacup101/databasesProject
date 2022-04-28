package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Tip;
import com.jacup101.yelp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TipRepository extends JpaRepository<Tip, String> {
    // pass in type and type for the primary key to access type 



    @Query("SELECT b from Business b WHERE b.businessId = ?1")
    List<Business> findBusinessByBusinessId(String businessId);

    @Query("SELECT u from User u WHERE u.userId = ?1")
    List<User> findUserByUserId(String userId);

    @Query("SELECT t from Tip t where t.businessId = ?1")
    List<Tip> getTipsByBusiness(String businessId);

    @Query("SELECT t from Tip t where t.userId = ?1")
    List<Tip> getTipsByUser(String userId);

    @Query("SELECT u from User u")
    List<User> getAllUsers();


}
