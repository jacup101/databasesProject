package com.jacup101.yelp.controller;

import java.util.List;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.User;
import com.jacup101.yelp.repository.UserRepository;

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
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    // http://localhost:8080/api/v1/employees
    @GetMapping("/users")
    public List<User> getAllUsers() {


        return userRepository.findAll();
        // select * from employee
    }


    // write a method that adds an employee to the db
    // when sending data to your server
    // it is better to send it in a request body
    // http://localhost:8080/api/v1/addemployee
    @PostMapping("/adduser")
    public User addUser(@RequestBody User e) {
        return userRepository.save(e);
        // insert into Employee (firstname, lastname, email)
        // values (e.firstname, e.lastname, e.email)
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable String id) {
        List<User> employee = userRepository.findByUserId(id);
        if(employee.size() <= 0) {
            throw new ResourceNotFoundException("User # " + id + "does not exist");
        }
        return ResponseEntity.ok(employee.get(0));
    }
    
    
}
