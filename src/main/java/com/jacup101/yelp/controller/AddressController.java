package com.jacup101.yelp.controller;

import java.util.List;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.Address;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.repository.AddressRepository;

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
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    
    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    // http://localhost:8080/api/v1/employees
    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {


        return addressRepository.findAll();
        // select * from employee
    }


    // write a method that adds an employee to the db
    // when sending data to your server
    // it is better to send it in a request body
    // http://localhost:8080/api/v1/addemployee
    @PostMapping("/addaddress")
    public Address addAddress(@RequestBody Address a) {
        //Address addr = addressRepository.save(a);
        List<Business> business = addressRepository.findBusinessByBusinessId(a.getBusinessId());
        List<Address> address = addressRepository.findByBusinessId(a.getBusinessId());
        if(business.size() <= 0) {
            throw new ResourceNotFoundException("Business does not exist");
        }
        if(address.size() > 0) {
            throw new ResourceNotFoundException("An addr already exists");
        }
        Business myBusiness = business.get(0);
        a.setBusiness(myBusiness);
        return addressRepository.save(a);
        // insert into Employee (firstname, lastname, email)
        // values (e.firstname, e.lastname, e.email)
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressByBusinessId(@PathVariable String id) {
        List<Address> employee = addressRepository.findByBusinessId(id);
        if(employee.size() <= 0) {
            throw new ResourceNotFoundException("User # " + id + "does not exist");
        }
        return ResponseEntity.ok(employee.get(0));
    }
}
