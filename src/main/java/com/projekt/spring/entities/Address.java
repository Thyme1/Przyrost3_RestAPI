package com.projekt.spring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@Entity
@Table(name="ADDRESSES")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String addressId;

    @Column(nullable=false)
    String street;

    @Column
    String city;

    @Column(length=5)
    String nr;

    @Column(length=5)
    String housenr;

    @Column(length=5, nullable=false)
    String postcode;

    @JsonProperty("AddressId")
    public Integer getId() {
        return id;

    }

    public Address() {
    }

    public Address(String addressId, String street, String city, String nr, String housenr, String postcode) {
        this.addressId=addressId;
        this.street=street;
        this.city=city;
        this.nr=nr;
        this.housenr=housenr;
        this.postcode=postcode;
    }





    public void setId(Integer idAdd) {
        this.id=idAdd;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street=street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city=city;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr=nr;
    }

    public String getHousenr() {
        return housenr;
    }

    public void setHousenr(String housenr) {
        this.housenr=housenr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode=postcode;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String productId) {
        this.addressId = productId;
    }


}


