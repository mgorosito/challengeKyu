package com.challenge.support;

public enum Locations {

    NEW_YORK("New york", "Davenport"),
    OHIO("Ohio", "Cincinnati"),
    CALIFORNIA("California", "San Diego");

    private String state;

    private String city;

    Locations(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public String state() {
        return state;
    }

    public String city() {
        return city;
    }
}