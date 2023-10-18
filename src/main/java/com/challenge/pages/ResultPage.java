package com.challenge.pages;

import com.challenge.webdriver.ExtendedWebDriver;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends Page {

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/div[2]/span")
    private WebElement totalResults;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/section/ol")
    private WebElement articlesDiv;


    public ResultPage(ExtendedWebDriver extendedWebDriver, Environment environment, String keyword) {
        super(extendedWebDriver, environment, ImmutableMap.of("keyword", keyword));
    }

    public Integer getTotalResults(){
        return Integer.valueOf(totalResults.getText().split(" ")[0].replace(".",""));
    }
    public List<String> getArticlesTitles() {
        return articlesDiv.findElements(By.className("ui-search-item__group--title")).stream()
                .map( a -> a.getText())
                .collect(Collectors.toList());
    }

}
