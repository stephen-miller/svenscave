package com.addressbook.row_Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Class that represents a row in the address table
 *
 * Created by Sven on 10/2/2016.
 */
@Entity
public class Address_row {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int zipcode;

    @Column
    private int zipcodeExtender;
    
    @Temporal(TemporalType.DATE)
    private Date lastChanged;

    public Address_row (){

    }

    public Address_row(String street, String city, String state, int zipcode, int zipcodeExtender) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.zipcodeExtender = zipcodeExtender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getZipcodeExtender() {
        return zipcodeExtender;
    }

    public void setZipcodeExtender(int zipcodeExtender) {
        this.zipcodeExtender = zipcodeExtender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }
}
