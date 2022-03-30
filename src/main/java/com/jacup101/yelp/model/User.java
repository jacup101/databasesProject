package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    
    @Column(name="user_id", length=22, nullable = false) private String userId;

    @Column(name="name", length=100, nullable = false) private String name;

    @Column(name="review_count") private short reviewCount;



    // Need a default constructor for the hibernate
    public User() {

    } // for hibernate

    public User(String userId, String name, short reviewCount) {
        this.userId = userId;
        this.name = name;
        this.reviewCount = reviewCount;

    }



    public short getReviewCount() {return reviewCount;}
    public String getName() {return name;}
    public String getUserId() {return userId;}

    public void setReviewCount(short reviewCount) {this.reviewCount = reviewCount;}
    public void setName(String name) {this.name = name;}
    public void setUserId(String userId) {this.userId = userId;}
    
}
