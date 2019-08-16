package com.herculis.model;

import com.herculis.annotation.Field;

public class ShipAddress {
    
    @Field("SHIPTOADDRESSLINE")
    private String line;

    @Field("SHIPTOCITY")
    private String city;

    @Field("SHIPTOCOUNTRY")
    private String country;

    @Field("SHIPTOPOSTALCODE")
    private String postalCode;

    @Field("SHIPTOPHONE")
    private String phone;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
