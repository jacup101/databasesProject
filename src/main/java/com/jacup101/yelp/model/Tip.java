package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tip")
public class Tip {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    

    @Column(name="text", length=65535, nullable = false, columnDefinition = "TEXT") private String text;

    @Column(name="date", length=50, nullable = false) private String date;
    
    @Column(name="compliment_count")  private short complimentCount;

    @Column(name="business_id", length=22, nullable = false) private String businessId;
    @Column(name="user_id", length=22, nullable = false) private String userId;

    @ManyToOne
    @JoinColumn(name="business")
    private Business business;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;


    // Need a default constructor for the hibernate
    public Tip() {

    } // for hibernate

    public Tip(String text, String date, short complimentCount, String businessId, String userId) {
        this.text = text;
        this.date = date;
        this.complimentCount = complimentCount;
        this.businessId = businessId;
        this.userId = userId;
    }

    public String getBusinessId() {return businessId;}
    public String getUserId() {return userId;}
    public String getDate() {return date;}
    public String getText() {return text;}
    public short getComplimentCountBigDecimal() {return complimentCount;}


    public void setBusiness(Business b) {this.business = b;}
    public void setUser(User u) {this.user = u;}
    public void setUserId(String id) {this.userId = id;}
    public void setDate(String d) {this.date = d;}
    public void setText(String t) {this.text = t;}
    public void setComplimentCount(short s) {this.complimentCount = s;}




}
