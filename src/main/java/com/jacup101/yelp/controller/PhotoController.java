package com.jacup101.yelp.controller;

import java.util.List;

import com.jacup101.yelp.misc.ResourceNotFoundException;
import com.jacup101.yelp.model.Business;
import com.jacup101.yelp.model.Photo;
import com.jacup101.yelp.repository.PhotoRepository;

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
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    
    // HTTP requests:
        // GET: not changing the database, but you are retrieving data from db
        // POST: send data to db to be recorded
    // write a method that returns all the employees information

    // http://localhost:8080/api/v1/employees
    @GetMapping("/photos")
    public List<Photo> getAllPhotos() {


        return photoRepository.findAll();
        // select * from employee
    }


    // write a method that adds an employee to the db
    // when sending data to your server
    // it is better to send it in a request body
    // http://localhost:8080/api/v1/addemployee
    @PostMapping("/addphoto")
    public Photo addPhoto(@RequestBody Photo p) {
        //Address addr = addressRepository.save(a);
        List<Business> business = photoRepository.findBusinessByBusinessId(p.getBusinessId());
        


        
        
        List<Photo> photos = photoRepository.findByPhotoId(p.getPhotoId());
        if(business.size() <= 0) {
            throw new ResourceNotFoundException("Business does not exist");
        }
        
        if(photos.size() > 0) {
            throw new ResourceNotFoundException("Photo Already Exists");
        }

        
        Business myBusiness = business.get(0);
        p.setBusiness(myBusiness);
        return photoRepository.save(p);
        // insert into Employee (firstname, lastname, email)
        // values (e.firstname, e.lastname, e.email)
    }

    // write a method to return an employee by its id
    // Path variable - meaning variable that you use becomes part of the path
    // http://localhost:8080/api/v1/employee/{id}

    @GetMapping("/photos/{id}")
    public ResponseEntity<Photo> getAddressByBusinessId(@PathVariable String id) {
        List<Photo> employee = photoRepository.findByPhotoId(id);
        if(employee.size() <= 0) {
            throw new ResourceNotFoundException("Photo with id: " + id + "does not exist");
        }
        return ResponseEntity.ok(employee.get(0));
    }
}
