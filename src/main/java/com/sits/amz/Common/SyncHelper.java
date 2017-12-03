package com.sits.amz.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mphome on 03/12/17.
 */
public class SyncHelper {

    protected static long timeoutInSecs = 450;

    public static WebElement waitForElementToBeVisible(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return element;
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, String locator, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return element;
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
