package com.jacup101.yelp.controller;

import java.util.List;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Review;
import com.jacup101.yelp.model.User;
import com.jacup101.yelp.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    // http://localhost:8080/api/v1/employees
    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
        // select * from employee
    }

    @GetMapping("/find_review_by_keyword/{keyword}")
    public List<Business> getReviewByKeyword(@PathVariable("keyword") String keyword) {
        return reviewRepository.search(keyword);
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getAddressByBusinessId(@PathVariable String id) {
        List<Review> employee = reviewRepository.findByReviewId(id);
        if(employee.size() <= 0) {
            throw new ResourceNotFoundException("User # " + id + "does not exist");
        }
        return ResponseEntity.ok(employee.get(0));
    }
}
