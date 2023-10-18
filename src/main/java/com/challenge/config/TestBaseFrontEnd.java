package com.challenge.config;

import com.challenge.pages.SiteMap;
import com.challenge.webdriver.ExtendedWebDriver;
import com.challenge.webdriver.WebDriverBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBaseFrontEnd extends TestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBaseFrontEnd.class);

    private static final int DRIVER_DIMENSION_WIDTH = 1600;

    private static final int DRIVER_DIMENSION_HEIGHT = 900;

    protected ExtendedWebDriver driver;

    protected SiteMap siteMap;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        driver = new ExtendedWebDriver(new WebDriverBuilder(this.environment).build());
        try {
            driver.maximize();
        } catch (WebDriverException e) {
            driver.manage().window().setSize(new Dimension(DRIVER_DIMENSION_WIDTH, DRIVER_DIMENSION_HEIGHT));
        }
        siteMap = new SiteMap(driver, this.environment);
        LOGGER.info("Setup done.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        driver.closeDriver();
        LOGGER.info("Driver closed");
    }

}


