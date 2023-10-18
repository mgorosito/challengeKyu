package com.challenge.backend;

import com.challenge.config.TestBase;
import com.challenge.helpers.BreweryApiHelper;
import com.challenge.model.api.brewery.Brewery;
import com.challenge.support.BreweryTypes;
import com.challenge.support.Locations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BreweryApiTests extends TestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreweryApiTests.class);

    @Autowired
    private BreweryApiHelper breweryApiHelper;

    @Test(groups = {"regression"},
            description = "Given a state when breweries from there are requested, then all results belongs to that state")
    public void givenAState_WhenBreweriesFromThereAreRequested_ThenAllResultsBelongsToThatState() {
        //GIVEN
        String state = Locations.CALIFORNIA.state();
        //WHEN
        List<Brewery> breweries = breweryApiHelper.getBreweriesByStateThroughApi(state);
        //THEN
        breweries.forEach(b -> softAssert.assertEquals(b.getState(), state));
        softAssert.assertAll();
    }

    @DataProvider(name = "breweryTypes")
    private Object[][] breweryTypes() {
        return new Object[][]
                {
                        {BreweryTypes.REGIONAL.description()},
                        {BreweryTypes.MICRO.description()},
                        {BreweryTypes.LARGE.description()},
                };
    }

    @Test(groups = {"regression"},
            description = "Given a brewery type when breweries with that types are requested, then all results belongs to that type",
            dataProvider = "breweryTypes")
    public void givenABreweryType_WhenBreweriesWithThatTypesAreRequested_ThenAllResultsBelongsToThatType(String breweryTypeDP) {
        //GIVEN
        String breweryType = breweryTypeDP;
        //WHEN
        List<Brewery> breweries = breweryApiHelper.getBreweriesByTypeThroughApi(breweryType);
        //THEN
        breweries.forEach(b -> softAssert.assertEquals(b.getBreweryType(), breweryType));
        softAssert.assertAll();
    }

    @Test(groups = {"regression"},
            description = "Given a keyword when it is searched, then a particular brewery is included within the response")
    public void givenAKeyword_WhenItIsSearched_ThenAParticularBreweryWithThatNameIsIncludedWithinTheResponse() {
        //GIVEN
        String keyword = "Lagunitas Brewing Co";
        List<Brewery> breweries = breweryApiHelper.searchBreweriesByKeywordThroughApi(keyword);
        //WHEN
        List<Brewery> californianBreweries = breweries.stream()
                .filter(b -> b.getState().equals(Locations.CALIFORNIA.state()))
                .collect(Collectors.toList());
        //THEN
        softAssert.assertEquals(californianBreweries.size(), 1);
        softAssert.assertEquals(californianBreweries.get(0).getName(), "Lagunitas Brewing Co");
        softAssert.assertEquals(californianBreweries.get(0).getStreet(), "1280 N McDowell Blvd");
        softAssert.assertEquals(californianBreweries.get(0).getPhone(), "7077694495");
        softAssert.assertAll();
    }
}
