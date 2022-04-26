package com.jacup101.yelp.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectController {
    @GetMapping("/frontend")
    ResponseEntity<Void> redirect() {
      return ResponseEntity.status(HttpStatus.FOUND)
          .location(URI.create("http://localhost:3000"))
          .build();
    }


    @GetMapping("/testredirect")
    ResponseEntity<Void> testtt() {
      return ResponseEntity.status(HttpStatus.FOUND)
          .location(URI.create("https://youtube.com"))
          .build();
    }
  
}
