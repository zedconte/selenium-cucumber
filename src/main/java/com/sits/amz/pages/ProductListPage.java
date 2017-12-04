package com.sits.amz.pages;

import com.sits.amz.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by mphome on 02/12/17.
 */
public class ProductListPage extends Page{

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

    /**
     * Returns Product Details for product at given Index
     * @param index: Index of Element in List (Zero being first element in list)
     * @return ProductDetailsPage
     */
    public ProductDetailsPage openProductDetailsAt(int index){
        WebElement secondProductInList = getProductResultLinkAt(index);
        secondProductInList.click();
        System.out.println("Clicked Second Product in the List");

        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }

    /**
     * Returns Product Link for element in the result List
     * @param index : Index of Element in List (Zero being first element in list)
     * @return Webelement (link to product in the list)
     */
    private WebElement getProductResultLinkAt(int index){
        WebElement productElementDiv = driver.findElement(By.xpath(String.format(Locators.ProductListPage
                .PRODUCT_RESULT_DIV,
                index)));
        WebElement productElementLink = driver.findElement(By.xpath(String.format(Locators.ProductListPage
                        .PRODUCT_RESULT_LINK,
                index)));
        scrollToElement(productElementDiv);
        WebElement element = syncHelper.waitForElementToBeVisible(this.driver, productElementLink);
        return element;
    }

    private Select getSortDropDown(){
        return new Select(driver.findElement(By.xpath(Locators.ProductListPage.SORT_BY)));
    }
}
