package com.example.supermarketrating;

import android.widget.TextView;

public class SuperMarket {
    private int supermarketID;
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    public SuperMarket() {
    }

    public int getMarketID() {
        return supermarketID;
    }

    public void setMarketID(int supermarketID) {
        this.supermarketID = supermarketID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
