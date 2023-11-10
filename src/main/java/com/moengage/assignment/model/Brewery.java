package com.moengage.assignment.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brewery_table")
public class Brewery {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address_1")
    private String address_1;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website_url")
    private String website_url;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "brewery_type")
    private String type;




    @Override
    public String toString() {
        return "Brewery{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", phone='" + phone + '\'' +
                ", website_url='" + website_url + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", brewery_type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrewery_type() {
        return type;
    }

    public void setBrewery_type(String brewery_type) {
        this.type = brewery_type;
    }
}