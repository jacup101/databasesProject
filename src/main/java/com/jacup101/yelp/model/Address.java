package com.jacup101.yelp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


// TODO: Map address to business id, not the other way around
// TODO: Make address controller not create dupes

@Entity
@Table(name="address")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    
    @Column(name="business_id", length=22, nullable = false) private String businessId;

    @Column(name="street", length=100, nullable = false) private String street;

    @Column(name="city", length=100, nullable = false) private String city;
    @Column(name="state", length=2, nullable = false) private String state;
    @Column(name="zip", length=20, nullable = false) private String zip;



    @OneToOne
    @JoinColumn(name="busLongId")
    private Business business;


    // Need a default constructor for the hibernate
    public Address() {

    } // for hibernate

    public Address(String businessId, String street, String city, String state, String zip) {
        this.businessId = businessId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }
    
    public String getBusinessId() {return businessId;}
    public String getStreet() {return street;}
    public String getCity() {return city;}
    public String getState() {return state;}
    public String getZip() {return zip;}


    public void setBusinessId(String businessId) {this.businessId = businessId;}
    public void setStreet(String street) {this.street = street;}
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setZip(String zip) {this.zip = zip;}
    public void setBusiness(Business business) {this.business = business;}
}
