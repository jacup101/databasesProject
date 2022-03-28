package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="business")
public class Business {

    @Id @Column(name="id", length=22, nullable = false) private String id;

    @Column(name="name", length=100, nullable = false) private String name;

    @Column(name="reviewcount") private short reviewCount;
    
    @Column(name="stars", precision=2, scale=1) private BigDecimal stars;

    @Column(name="category",length=1000) private String category;


    // Need a default constructor for the hibernate
    public Business() {

    } // for hibernate

    public Business(String id, String name, short reviewCount, BigDecimal stars, String category) {
        this.id = id;
        this.name = name;
        this.reviewCount = reviewCount;
        this.stars = stars;
        this.category = category;
    }


    public BigDecimal getStars() {return stars;}
    public short getReviewCount() {return reviewCount;}
    public String getName() {return name;}
    public String getCategory() {return category;}
    public String getId() {return id;}

    public void setStars(BigDecimal stars) {this.stars = stars;}
    public void setReviewCount(short reviewCount) {this.reviewCount = reviewCount;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setId(String id) {this.id = id;}
}
