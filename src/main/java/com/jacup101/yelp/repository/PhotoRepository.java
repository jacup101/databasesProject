package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PhotoRepository extends JpaRepository<Photo, String> {
    // pass in type and type for the primary key to access type 


    List<Photo> findByPhotoId(String photoId);

    @Query("SELECT b from Business b WHERE b.businessId = ?1")
    List<Business> findBusinessByBusinessId(String businessId);


}
