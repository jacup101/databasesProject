package com.jacup101.yelp.repository;
import java.util.List;

import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Review;
import com.jacup101.yelp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ReviewRepository extends JpaRepository<Review, String> {
    // pass in type and type for the primary key to access type


    List<Review> findByReviewId(String reviewId);

    @Query("SELECT b from Business b WHERE b.businessId = ?1")
    List<Business> findBusinessByBusinessId(String businessId);

    @Query("SELECT u from User u WHERE u.userId = ?1")
    List<User> findUserByUserId(String userId);

    @Query("SELECT r FROM Review r WHERE r.text LIKE %?1%")
    List<Business> search(String keyword);

  @Query("SELECT r from Review r")
    List<User> getAllReviews();

}
