package com.challenge.clients;

import com.challenge.model.api.brewery.Brewery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

import static io.restassured.RestAssured.given;

@Component
public class BreweryApiClient extends CommonClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreweryApiClient.class);

    @Value("${openbrewerydb.host}")
    private String host;

    @Value("${openbrewerydb.breweries.get.all}")
    private String getAllBreweriesEndPoint;

    @Value("${openbrewerydb.brewery.details}")
    private String getBreweryDetailsEndPoint;

    @Value("${openbrewerydb.brewery.search}")
    private String searchBreweriesEndPoint;

    public BreweryApiClient() { }

    public Brewery[] getAllBreweries() {
        LOGGER.info("Trying to get all breweries ...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(false)
                    .when().get(getAllBreweriesEndPoint)
                        .then().extract().response().as(Brewery[].class);
    }

    public Brewery getBreweryDetails(String id) {
        LOGGER.info("Trying to get brewery details...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(false)
                .when().get(MessageFormat.format(getBreweryDetailsEndPoint, id))
                    .then().extract().response().as(Brewery.class);
    }

    public Brewery[] searchBreweries(String keyword) {
        LOGGER.info("Trying to search for breweries by keyword...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(true)
                .queryParam("query", keyword)
                    .when().get(searchBreweriesEndPoint)
                        .then().extract().response().as(Brewery[].class);
    }

    public Brewery[] getBreweriesByState(String state) {
        LOGGER.info("Trying to get breweries by state...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(false)
                .queryParam("by_state", state)
                    .when().get(getAllBreweriesEndPoint)
                        .then().extract().response().as(Brewery[].class);
    }

    public Brewery[] getBreweriesByCity(String city) {
        LOGGER.info("Trying to get breweries by city...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(false)
                .queryParam("by_city", city)
                    .when().get(getAllBreweriesEndPoint)
                        .then().extract().response().as(Brewery[].class);
    }

    public Brewery[] getBreweriesByName(String name) {
        LOGGER.info("Trying to get breweries by name...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(false)
                .queryParam("by_name", name)
                    .when().get(getAllBreweriesEndPoint)
                        .then().extract().response().as(Brewery[].class);
    }

    public Brewery[] getBreweriesByType(String type) {
        LOGGER.info("Trying to get breweries by type...");
        return given().spec(setBaseUriAs(host)).urlEncodingEnabled(false)
                .queryParam("by_type", type)
                    .when().get(getAllBreweriesEndPoint)
                        .then().extract().response().as(Brewery[].class);
    }
}
