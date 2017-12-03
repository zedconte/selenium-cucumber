package com.sits.amz.pages;

import com.sits.amz.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by mphome on 02/12/17.
 */
public class ProductListPage extends Page{

    @FindBy(xpath = Locators.ProductListPage.SECOND_PRODUCT_RESULT_DIV)
    private WebElement secondProductResultDiv;

    @FindBy(xpath = Locators.ProductListPage.SECOND_PRODUCT_RESULT_LINK)
    private WebElement secondProductResultLink;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void sortByPrice(){
        Select sort_by_drop_down = getSortDropDown();
        List<WebElement> options = sort_by_drop_down.getOptions();
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).getText().equals(Locators.ProductListPage.PRICE_HIGH_TO_LOW)){
                options.get(i).click();
                break;
            }
        }
    }

    public ProductDetailsPage openProductDetailsPage(){
        WebElement secondProductInList = getSecondProductResultLink();
        secondProductInList.click();
        System.out.println("Clicked Second Product in the List");

        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }

    private WebElement getSecondProductResultLink(){
        scrollToElement(secondProductResultDiv);
        WebElement secondElement = syncHelper.waitForElementToBeVisible(this.driver, secondProductResultLink);
        return secondElement;
    }

    private Select getSortDropDown(){
        return new Select(driver.findElement(By.xpath(Locators.ProductListPage.SORT_BY)));
    }
}
