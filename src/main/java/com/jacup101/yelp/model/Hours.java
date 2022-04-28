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
@Table(name="hours")
public class Hours {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    
    @Column(name="business_id", length=22, nullable = false) private String businessId;

    @Column(name="monday", length=20, nullable = false) private String monday = "Closed";
    @Column(name="tuesday", length=20, nullable = false) private String tuesday = "Closed";
    @Column(name="wednesday", length=20, nullable = false) private String wednesday = "Closed";
    @Column(name="thursday", length=20, nullable = false) private String thursday = "Closed";
    @Column(name="friday", length=20, nullable = false) private String friday = "Closed";
    @Column(name="saturday", length=20, nullable = false) private String saturday = "Closed";
    @Column(name="sunday", length=20, nullable = false) private String sunday = "Closed";





    @OneToOne
    @JoinColumn(name="busLongId")
    private Business business;


    // Need a default constructor for the hibernate
    public Hours() {

    } // for hibernate

    public Hours(String businessId, String mon, String tues, String wed, String thurs, String fri, String sat, String sun) {
        this.businessId = businessId;
        this.monday = mon;
        this.tuesday = tues;
        this.wednesday = wed;
        this.thursday = thurs;
        this.friday = fri;
        this.saturday = sat;
        this.sunday = sun;
    }
    
    public String getBusinessId() {return businessId;}
    public String getMonday() {return monday;}
    public String getTuesday() {return tuesday;}
    public String getWednesday() {return wednesday;}
    public String getThursday() {return thursday; }
    public String getFriday() {return friday; }
    public String getSaturday() {return saturday; }
    public String getSunday() {return sunday; }



    public void setBusinessId(String businessId) {this.businessId = businessId;}
    public void setMonday(String mon) {this.monday = mon;}
    public void setTuesday(String tues) {this.tuesday = tues;}
    public void setWednesday(String wed) {this.wednesday = wed;}
    public void setThursday(String thurs) {this.thursday = thurs;}
    public void setFriday(String fri) {this.friday = fri;}

    public void setBusiness(Business business) {this.business = business;}
}
