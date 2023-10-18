package com.challenge.config;

import com.challenge.utils.BaseHTMLReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {BaseConf.class})
@Listeners(BaseHTMLReporter.class)
public class TestBase extends AbstractTestNGSpringContextTests  {

    @Autowired
    protected Environment environment;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    protected  SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

    @BeforeMethod(alwaysRun = true)
    protected void logStartTest() {
        logInfo("TEST-START.");
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    protected void logEndTest() {
        logInfo("TEST-END.");
    }

    @AfterSuite(alwaysRun = true)
    protected void logSuiteFinished() {
        logInfo("Suite execution FINISHED.");
    }

    protected void logInfo(String message) {
        LOGGER.info(message);
    }

}
