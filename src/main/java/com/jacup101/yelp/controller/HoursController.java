package com.jacup101.yelp.controller;

import java.util.List;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Hours;
import com.jacup101.yelp.repository.HoursRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/") 
// http://localhost:8080/api/v1/
public class HoursController {

    @Autowired
    private HoursRepository hoursRepository;
    
    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    // http://localhost:8080/api/v1/employees
    @GetMapping("/hours")
    public List<Hours> getAllHours() {


        return hoursRepository.findAll();
        // select * from employee
    }


    // write a method that adds an employee to the db
    // when sending data to your server
    // it is better to send it in a request body
    // http://localhost:8080/api/v1/addemployee
    @PostMapping("/addhours")
    public Hours addHours(@RequestBody Hours h) {
        //Address addr = addressRepository.save(a);
        List<Business> business = hoursRepository.findBusinessByBusinessId(h.getBusinessId());
        List<Hours> hours = hoursRepository.findByBusinessId(h.getBusinessId());
        if(business.size() <= 0) {
            throw new ResourceNotFoundException("Business does not exist");
        }
        if(hours.size() > 0) {
            throw new ResourceNotFoundException("Hours already exist for this business");
        }
        Business myBusiness = business.get(0);
        h.setBusiness(myBusiness);
        return hoursRepository.save(h);
        // insert into Employee (firstname, lastname, email)
        // values (e.firstname, e.lastname, e.email)
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/hours/{id}")
    public ResponseEntity<Hours> getAddressByBusinessId(@PathVariable String id) {
        List<Hours> hours = hoursRepository.findByBusinessId(id);
        if(hours.size() <= 0) {
            throw new ResourceNotFoundException("Hours for business with id: " + id + "does not exist");
        }
        return ResponseEntity.ok(hours.get(0));
    }
}
