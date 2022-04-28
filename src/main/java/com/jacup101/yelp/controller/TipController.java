package com.jacup101.yelp.controller;

import java.util.List;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Tip;
import com.jacup101.yelp.model.User;
import com.jacup101.yelp.repository.TipRepository;

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
public class TipController {

    @Autowired
    private TipRepository tipRepository;

    private List<User> allUsers;
    
    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    // http://localhost:8080/api/v1/employees
    @GetMapping("/tips")
    public List<Tip> getAllTips() {


        return tipRepository.findAll();
        // select * from employee
    }


    // write a method that adds an employee to the db
    // when sending data to your server
    // it is better to send it in a request body
    // http://localhost:8080/api/v1/addemployee
    @PostMapping("/addtip")
    public Tip addTip(@RequestBody Tip t) {
        //Address addr = addressRepository.save(a);
        List<Business> business = tipRepository.findBusinessByBusinessId(t.getBusinessId());
        
        if(allUsers == null) {
            allUsers = tipRepository.getAllUsers();
        }
        if(t.getUserId().equals("random")) {
            int rand = (int) (Math.random() * allUsers.size());
            t.setUserId(allUsers.get(rand).getUserId());
            
        }
        
        
        List<User> user = tipRepository.findUserByUserId(t.getUserId());
        if(business.size() <= 0) {
            throw new ResourceNotFoundException("Business does not exist");
        }
        if(user.size() <= 0) {
            throw new ResourceNotFoundException("User does not exist");
        }
        

        
        Business myBusiness = business.get(0);
        User myUser = user.get(0);
        t.setBusiness(myBusiness);
        t.setUser(myUser);
        return tipRepository.save(t);
        // insert into Employee (firstname, lastname, email)
        // values (e.firstname, e.lastname, e.email)
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/tips/business/{id}")
    public ResponseEntity<List<Tip>> getTipsbyBusinessId(@PathVariable String id) {
        List<Tip> tips = tipRepository.getTipsByBusiness(id);
        if(tips.size() <= 0) {
            throw new ResourceNotFoundException("Tips for business with id: " + id + "does not exist");
        }
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/tips/user/{id}")
    public ResponseEntity<List<Tip>> getTipsByUserId(@PathVariable String id) {
        List<Tip> tips = tipRepository.getTipsByUser(id);
        if(tips.size() <= 0) {
            throw new ResourceNotFoundException("Tips for user with id: " + id + "does not exist");
        }
        return ResponseEntity.ok(tips);
    }
}
