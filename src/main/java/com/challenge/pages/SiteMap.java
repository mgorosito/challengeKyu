package com.challenge.pages;

import com.challenge.webdriver.ExtendedWebDriver;
import org.springframework.core.env.Environment;

public class SiteMap {

    private final ExtendedWebDriver extendedWebDriver;

    private Environment environment;

    public SiteMap(ExtendedWebDriver extendedWebDriver, Environment environment) {
        this.extendedWebDriver = extendedWebDriver;
        this.environment = environment;
    }

    public LoginPage loginPage() {
        extendedWebDriver.get(environment.getProperty("site.host"));
        return new LoginPage(extendedWebDriver, environment);
    }

}
