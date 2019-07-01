package com.sits.amz.common;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;

/**
 * Base class for TestNG-based test classes
 */
public class TestBase {

    protected static URL gridHubUrl = null;
    protected static Capabilities capabilities;

    public String baseUrl;
    public WebDriver driver;

    /**
     *  Read Configuration files and initialise properties
     *  @throws IOException
     */
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
    public void initWebDriver()  {
        System.out.println("InitWebDriver");
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    }

    /**
     * Quit all browsers & Destroy driver
     */
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}