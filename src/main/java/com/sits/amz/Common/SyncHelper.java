package com.sits.amz.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Mrudul Pendharkar.
 */
public class SyncHelper {

    protected static long timeoutInSecs = 450;

    public static WebElement waitForElementToBeVisible(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return element;
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
