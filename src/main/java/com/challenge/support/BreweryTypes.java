package com.challenge.support;

public enum BreweryTypes {

    MICRO("micro"),
    REGIONAL("regional"),
    LARGE("large");

    private String description;

    BreweryTypes(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
