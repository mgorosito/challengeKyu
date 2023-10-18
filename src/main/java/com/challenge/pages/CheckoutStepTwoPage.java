package com.challenge.pages;

import com.challenge.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

public class CheckoutStepTwoPage extends Page {

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(ExtendedWebDriver extendedWebDriver, Environment environment) {
        super(extendedWebDriver, environment);
    }

    public CheckoutCompletePage clickOnFinishButton() {
        finishButton.click();
        return new CheckoutCompletePage(webDriver, environment);
    }

}
