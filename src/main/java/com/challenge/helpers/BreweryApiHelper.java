package com.challenge.helpers;

import com.challenge.clients.BreweryApiClient;
import com.challenge.model.api.brewery.Brewery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BreweryApiHelper extends CommonHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreweryApiHelper.class);

    @Autowired
    private BreweryApiClient breweryApiClient;

    public Brewery[] getAllBreweriesFromApi() {
        return breweryApiClient.getAllBreweries();
    }

    public Brewery getAnyBreweryFromApi() {
        return Arrays.stream(breweryApiClient.getAllBreweries())
                .findAny().get();
    }

    public Brewery getBreweryDetailsFromApi(String id) {
        return breweryApiClient.getBreweryDetails(id);
    }

    public List<Brewery> searchBreweriesByKeywordThroughApi(String keyword) {
        return Arrays.stream(breweryApiClient.searchBreweries(keyword)).collect(Collectors.toList());
    }

    public List<Brewery> getBreweriesByStateThroughApi(String state) {
        return Arrays.stream(breweryApiClient.getBreweriesByState(state)).collect(Collectors.toList());
    }

    public List<Brewery> getBreweriesByCityThroughApi(String city) {
        return Arrays.stream(breweryApiClient.getBreweriesByCity(city)).collect(Collectors.toList());
    }

    public List<Brewery> getBreweriesByNameThroughApi(String name) {
        return Arrays.stream(breweryApiClient.getBreweriesByName(name)).collect(Collectors.toList());
    }

    public List<Brewery> getBreweriesByTypeThroughApi(String type) {
        return Arrays.stream(breweryApiClient.getBreweriesByType(type)).collect(Collectors.toList());
    }
}
