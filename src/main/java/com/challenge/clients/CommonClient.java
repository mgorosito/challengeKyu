package com.challenge.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public abstract class CommonClient {

    protected RequestSpecification setBaseUriAs(String host) {
        return new RequestSpecBuilder()
                .setBaseUri(host)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
