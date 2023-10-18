package com.challenge.frontend;

import com.challenge.config.TestBaseFrontEnd;
import com.challenge.pages.*;
import org.testng.annotations.Test;

public class DemoTestFrontSauce extends TestBaseFrontEnd {

    @Test(groups = {"regression"},
            description = "Given a login with valid credentials, when an item is added to the cart and the checkout steps are finished" +
                    " then the thank you message is shown and it is the expected one.")
    public void givenALoginWithValidCredentials_whenAnItemIsAddedToTheCart_AndTheCheckoutStepsAreFinished_thenTheThankYouMessageIsShown_AndItIsTheExpectedOne() {
        //GIVEN
        LoginPage loginPage = siteMap.loginPage();
        InventoryPage inventoryPage = loginPage.loginAs("standard_user","secret_sauce");
        //WHEN
        inventoryPage.addAnyItemToCart();
        CartPage cartPage = inventoryPage.clickOnCartIcon();
        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickOnCheckoutButton();
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.fillPersonalInformation("Juan","Diaz", "1653");
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickOnFinishButton();
        //THEN
        softAssert.assertTrue(checkoutCompletePage.isThankYouElementDisplayed());
        softAssert.assertEquals(checkoutCompletePage.getThankYouMessage(),"Thank you for your order!");
        softAssert.assertAll();
    }
}
