package com.challenge.pages;

import com.challenge.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

public class CartPage extends Page {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(ExtendedWebDriver extendedWebDriver, Environment environment) {
        super(extendedWebDriver, environment);
    }

    public CheckoutStepOnePage clickOnCheckoutButton() {
        checkoutButton.click();
        return new CheckoutStepOnePage(webDriver, environment);
    }

}
