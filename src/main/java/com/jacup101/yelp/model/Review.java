package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="review")
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    
    @Column(name="review_id", length=22, nullable = false) private String reviewId;

    @Column(name="text", length=65535, nullable = false, columnDefinition = "TEXT") private String text;

    @Column(name="date", length=50, nullable = false) private String date;
    
    @Column(name="stars", precision=2, scale=1) private BigDecimal stars;

    @Column(name="business_id", length=22, nullable = false) private String businessId;
    @Column(name="user_id", length=22, nullable = false) private String userId;

    @ManyToOne
    @JoinColumn(name="business")
    private Business business;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;


    // Need a default constructor for the hibernate
    public Review() {

    } // for hibernate

    public Review(String reviewId, String text, String date, BigDecimal stars, String businessId, String userId) {
        this.reviewId = reviewId;
        this.text = text;
        this.date = date;
        this.stars = stars;
        this.businessId = businessId;
        this.userId = userId;
    }

    public String getBusinessId() {return businessId;}
    public String getReviewId() {return reviewId;}
    public String getUserId() {return userId;}
    public String getDate() {return date;}
    public String getText() {return text;}
    public BigDecimal getStars() {return stars;}


    public void setBusiness(Business b) {this.business = b;}
    public void setUser(User u) {this.user = u;}
    public void setUserId(String id) {this.userId = id;}
    public void setDate(String d) {this.date = d;}
    public void setText(String t) {this.text = t;}
    public void setStars(BigDecimal s) {this.stars = s;}




}
