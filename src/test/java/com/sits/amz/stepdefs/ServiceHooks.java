package com.sits.amz.stepdefs;

import com.sits.amz.common.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;

/**
 * Created by Mrudul Pendharkar.
 */
public class ServiceHooks extends TestBase{

    private TestBase baseRef;

    public ServiceHooks(TestBase baseRef) {
        this.baseRef = baseRef;
    }

    /**
     *  Initialise Driver
     *
     */
    @Before
    public void initializeTest() throws IOException {
        baseRef.initTestSuite();
        baseRef.driver = WebDriverPool.DEFAULT.getDriver(TestBase.gridHubUrl, TestBase.capabilities);
    }

    /**
     * Quit all browsers & Destroy driver
     */
    @After
    public void embedScreenshot(Scenario scenario) {
        baseRef.tearDown();
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
                System.out.println("Scenario Failed::" + scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}