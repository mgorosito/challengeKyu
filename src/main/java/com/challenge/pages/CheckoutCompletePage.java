package com.challenge.pages;

import com.challenge.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

public class CheckoutCompletePage extends Page {

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    public CheckoutCompletePage(ExtendedWebDriver extendedWebDriver, Environment environment) {
        super(extendedWebDriver, environment);
    }

    public boolean isThankYouElementDisplayed() {
        return thankYouMessage.isDisplayed();
    }

    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }

}
