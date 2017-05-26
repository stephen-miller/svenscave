package com.addressbook.controller;

import com.addressbook.dao.AddressRepository;
import com.addressbook.row_Objects.Address_row;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the endpoint of the AddressBook microservice
 *
 * Created by Sven on 10/2/2016.
 */
@RestController
public class Endpoint {

    @Autowired
    AddressRepository dao;

    @Autowired
    Gson gson;

    @RequestMapping(value = "/getaddressbyid/{id}", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity getAddressById(@PathVariable("id") long id){
        Address_row returnedAddress = dao.findOne(id);
        String body = gson.toJson(returnedAddress);
        return new ResponseEntity(body, HttpStatus.OK);
    }

    @RequestMapping(value = "/savenewaddress/street/{street}/city/{city}/statecode/{statecode}/zipcode/{zipcode}/zipcodeext/{zipcodeext}", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity saveNewAddress(@PathVariable("street") String street,
                                         @PathVariable("city") String city,
                                         @PathVariable("statecode") String state,
                                         @PathVariable("zipcode") int zip,
                                         @PathVariable("zipcodeext") int zipExt){
        Address_row newAddress = new Address_row(street, city, state, zip, zipExt);
        dao.save(newAddress);
        String body = gson.toJson(null);
        return new ResponseEntity(body, HttpStatus.OK);
    }



}
