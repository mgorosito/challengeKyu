package com.challenge.model.api.brewery;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery {

    private String id;

    private String name;

    @JsonProperty("brewery_type")
    private String breweryType;

    private String street;

    @JsonProperty("address_1")
    private String address1;
    @JsonProperty("address_2")
    private String address2;

    @JsonProperty("address_3")
    private String address3;

    private String city;

    private String state;

    @JsonProperty("state_province")
    private String stateProvince;

    @JsonProperty("county_province")
    private String countyProvince;

    @JsonProperty("postal_code")
    private String postalCode;

    private String country;

    private String longitude;

    private String latitude;

    private String phone;

    @JsonProperty("website_url")
    private String websiteUrl;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("created_at")
    private String createdAt;

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

    public String getBreweryType() {
        return breweryType;
    }

    public void setBreweryType(String breweryType) {
        this.breweryType = breweryType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
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

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountyProvince() {
        return countyProvince;
    }

    public void setCountyProvince(String countyProvince) {
        this.countyProvince = countyProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", breweryType='" + breweryType + '\'' +
                ", street='" + street + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", state_province='" + stateProvince + '\'' +
                ", state='" + state + '\'' +
                ", countyProvince='" + countyProvince + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", phone='" + phone + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
