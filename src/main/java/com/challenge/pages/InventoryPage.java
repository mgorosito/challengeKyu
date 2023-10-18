package com.challenge.pages;

import com.challenge.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

import java.util.List;

public class InventoryPage extends Page {

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    public InventoryPage(ExtendedWebDriver extendedWebDriver, Environment environment) {
        super(extendedWebDriver, environment);
    }

    public void addAnyItemToCart() {
        items.stream().findAny().get()
                .findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();
    }

    public CartPage clickOnCartIcon() {
        cartIcon.click();
        return new CartPage(webDriver, environment);
    }

}
