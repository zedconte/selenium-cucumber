package com.sits.amz.common;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    /**
     *  Read Configuration files and initialise properties
     *  @throws IOException
     */
    @BeforeSuite
    public void initTestSuite() throws IOException {

        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
    }

    /**
     *  Initialise Driver
     *
     */
    @BeforeMethod
    public void initWebDriver() {

        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    }

    /**
     * Quit all browsers & Destroy driver
     */
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
