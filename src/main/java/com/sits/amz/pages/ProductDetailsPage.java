package com.sits.amz.pages;

import com.sits.amz.locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by mphome on 02/12/17.
 */
public class ProductDetailsPage extends Page{

    @FindBy(xpath = Locators.ProductDetailPage.PRODUCT_TITLE)
    @CacheLookup
    private WebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle(){
        return productTitle.getText();
    }
}
