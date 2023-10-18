package com.challenge.webdriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.core.env.Environment;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.System.getProperty;

public class WebDriverBuilder {

    private Environment environment;

    private static final List<String> BROWSER_LIST = Arrays.asList("chrome");

    private final String BROWSER = Optional.ofNullable(getProperty("browser")).orElse("chrome");

    public WebDriverBuilder(Environment environment) {
        this.environment = environment;
        validateBrowser();
        setBrowserDriverPath();
    }

    private void validateBrowser() {
        if (BROWSER.isEmpty() || !BROWSER_LIST.contains(BROWSER)) {
            throw new RuntimeException("Not supported browser value: " + BROWSER);
        }
    }

    public WebDriver build() {
        switch (BROWSER) {
            case "chrome-headless":
                return new ChromeDriver(CapabilitiesFiller.buildChromeHeadless());
                default:
                    return new ChromeDriver(CapabilitiesFiller.buildChrome());
        }
    }

    private void setBrowserDriverPath() {
        OS os = OS.fromString(System.getProperty("os.name"));
        String driverPath = MessageFormat.format("driver.path.{0}.{1}", BROWSER, os);
        String driverPropertyKey = MessageFormat.format("driver.property.{0}.{1}", BROWSER, os);
        System.setProperty(this.environment.getProperty(driverPropertyKey), this.environment.getProperty(driverPath));
    }

    enum OS {
        linux, mac, win;
        public static OS fromString(String text) {
            return Arrays.stream(OS.values()).filter(value -> text.toLowerCase().contains(value.name()))
                    .findFirst().orElse(null);
        }
    }

    public static class CapabilitiesFiller {

        public static ChromeOptions buildChrome() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("chrome", Platform.ANY);
            return chromeOptions;
        }

        public static ChromeOptions buildChromeHeadless() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            return chromeOptions;
        }

    }
}
