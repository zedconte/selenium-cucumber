package com.sits.amz.pages;

import com.sits.amz.locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage extends Page {
    @FindBy(id = Locators.HomePage.SEARCH_BOX)
    @CacheLookup
    private WebElement searchBox;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductListPage search_product(String productKeyWord){
        this.searchBox.sendKeys(productKeyWord);
        this.searchBox.submit();
        return PageFactory.initElements(driver, ProductListPage.class);
    }

}
