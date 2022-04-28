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
@Table(name="photo")
public class Photo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    
    @Column(name="photo_id", length=22, nullable = false) private String photoId;

    @Column(name="caption", length=65535, nullable = false, columnDefinition = "TEXT") private String caption;

    @Column(name="label", length=100, nullable = false) private String label;
    
    @Column(name="business_id", length=22, nullable = false) private String businessId;

    @ManyToOne
    @JoinColumn(name="business")
    private Business business;

  


    // Need a default constructor for the hibernate
    public Photo() {

    } // for hibernate

    public Photo(String photoId, String caption, String label, String businessId) {
        this.photoId = photoId;
        this.caption = caption;
        this.label = label;
        this.businessId = businessId;
    }

    public String getBusinessId() {return businessId;}
    public String getPhotoId() {return photoId;}
    public String getCaption() {return caption;}
    public String getLabel() {return label;}


    public void setBusiness(Business b) {this.business = b;}
    public void setPhotoId(String id) {this.photoId = id;}
    public void setCaption(String t) {this.caption = t;}
    public void setLabel(String s) {this.label = s;}




}
