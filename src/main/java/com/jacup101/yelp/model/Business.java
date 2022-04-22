package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="business")
public class Business {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;

    @Column(name="business_id", length=22, nullable = false) private String businessId;

    @Column(name="name", length=100, nullable = false) private String name;

    @Column(name="review_count") private short reviewCount;

    @Column(name="stars", precision=2, scale=1) private BigDecimal stars;

    @Column(name="category",length=1000) private String category;

    @OneToOne(mappedBy = "business")
    private Address address;


    // Need a default constructor for the hibernate
    public Business() {

    } // for hibernate

    // for mock display
    public Business(String businessId, String name, String category) {
        this.businessId = businessId;
        this.name = name;
        this.reviewCount = new Short("0");
        this.stars = new BigDecimal("0");
        this.category = category;
    }

    public Business(String businessId, String name, short reviewCount, BigDecimal stars, String category) {
        this.businessId = businessId;
        this.name = name;
        this.reviewCount = reviewCount;
        this.stars = stars;
        this.category = category;
    }


    public BigDecimal getStars() {return stars;}
    public short getReviewCount() {return reviewCount;}
    public String getName() {return name;}
    public String getCategory() {return category;}
    public String getBusinessId() {return businessId;}

    public void setStars(BigDecimal stars) {this.stars = stars;}
    public void setReviewCount(short reviewCount) {this.reviewCount = reviewCount;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setBusinessId(String businessId) {this.businessId = businessId;}
    public void setAddress(Address address) {this.address = address;}
}
