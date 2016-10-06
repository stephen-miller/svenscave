package org.webservice.forms;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sven on 10/2/2016.
 */
public class AddressForm {

    @NotNull
    @Size(min=5, max=50)
    private String street;

    @NotNull
    @Size(min=5, max=50)
    private String city;

    @NotNull
    @Length(min = 2, max = 2, message = "The field must be exactly 2 characters")
    private String state;

    @NotNull
    @Digits(integer = 5, fraction = 0)
    private int zipcode;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private int zipcodeExtender;

    public AddressForm() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
