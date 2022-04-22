package com.jacup101.yelp.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.repository.BusinessRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
// http://localhost:8080/api/v1/
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    @GetMapping("/all_businesses")
    public List<Business> getBusinesses() {
        return Arrays.asList(new Business("1", "Papa Hut", "resturant"), new Business("2", "Denimos", "resturant"), new Business("3", "McDorger King", "resturant"));
    }

    // http://localhost:8080/api/v1/employees
    @GetMapping("/businesses")
    public List<Business> getAllEmployees() {
        return businessRepository.findAll();
        // select * from employee
    }

    @GetMapping("/find_business_by_keyword/{keyword}")
    public List<Business> getAllEmployees(@PathVariable("keyword") String keyword) {
        return businessRepository.search(keyword);
    }


    // write a method that adds an employee to the db
    // when sending data to your server
    // it is better to send it in a request body
    // http://localhost:8080/api/v1/addemployee
    @PostMapping("/addbusiness")
    public Business addEmployee(@RequestBody Business e) {
        return businessRepository.save(e);
        // insert into Employee (firstname, lastname, email)
        // values (e.firstname, e.lastname, e.email)
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/businesses/{id}")
    public ResponseEntity<Business> getEmployeeByBusinessId(@PathVariable String id) {
        List<Business> employee = businessRepository.findByBusinessId(id);
        if(employee.size() <= 0) {
            throw new ResourceNotFoundException("Employee # " + id + "does not exist");
        }
        return ResponseEntity.ok(employee.get(0));
    }

    @GetMapping("/search/businesses/{text}")
    public ResponseEntity<List<Business>> searchBusinesses(@PathVariable String text) {
        List<Business> businesses = businessRepository.search(text);
        if(businesses.size() <= 0) {
            throw new ResourceNotFoundException("Employee # " + text + "does not exist");
        }
        return ResponseEntity.ok(businesses);

    }

    @GetMapping("/search/businesses/stars/equals/{stars}")
    public ResponseEntity<List<Business>> starsEqual(@PathVariable BigDecimal stars) {
        List<Business> businesses = businessRepository.starsEquals(stars);
        if(businesses.size() <= 0) {
            throw new ResourceNotFoundException("No businesses with these stars " + stars);
        }
        return ResponseEntity.ok(businesses);
    }
    @GetMapping("/search/businesses/stars/greater/{stars}")
    public ResponseEntity<List<Business>> starsGreater(@PathVariable BigDecimal stars) {
        List<Business> businesses = businessRepository.starsGreater(stars);
        if(businesses.size() <= 0) {
            throw new ResourceNotFoundException("No businesses with these stars " + stars);
        }
        return ResponseEntity.ok(businesses);
    }
    @GetMapping("/search/businesses/stars/less/{stars}")
    public ResponseEntity<List<Business>> starsLess(@PathVariable BigDecimal stars) {
        List<Business> businesses = businessRepository.starsLess(stars);
        if(businesses.size() <= 0) {
            throw new ResourceNotFoundException("No businesses with these stars " + stars);
        }
        return ResponseEntity.ok(businesses);
    }


}
