package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="business")
public class Business {

    @Id @Column(name="business_id", length=22, nullable = false) private String business_id;

    @Column(name="name", length=100, nullable = false) private String name;

    @Column(name="review_count") private short review_count;
    
    @Column(name="stars", precision=2, scale=1) private BigDecimal stars;

    @Column(name="category",length=1000) private String category;


    // Need a default constructor for the hibernate
    public Business() {

    } // for hibernate

    public Business(String id, String name, short reviewCount, BigDecimal stars, String category) {
        this.business_id = id;
        this.name = name;
        this.review_count = reviewCount;
        this.stars = stars;
        this.category = category;
    }


    public BigDecimal getStars() {return stars;}
    public short getReviewCount() {return review_count;}
    public String getName() {return name;}
    public String getCategory() {return category;}
    public String getBusinessId() {return business_id;}

    public void setStars(BigDecimal stars) {this.stars = stars;}
    public void setReviewCount(short reviewCount) {this.review_count = reviewCount;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setBusinessId(String id) {this.business_id = id;}
}
