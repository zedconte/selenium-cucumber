package com.sits.amz.pages;

import com.sits.amz.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Mrudul Pendharkar.
 */
public class ProductListPage extends Page{

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sorts Result by Price
     */
    public void sortByPrice(){
        Select sort_by_drop_down = getSortByDropDown();
        List<WebElement> options = sort_by_drop_down.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(Locators.ProductListPage.PRICE_HIGH_TO_LOW)) {
                option.click();
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
     * Verifies Price is sorted by Price
     *
     * @return True if price is sorted else False
     */
    public boolean verifyProductListIsSortedByPrice(boolean ascending){
        String productSortedListString = "";
        WebElement productSortedListLabel = null;

        // Verifying Element is visible
        syncHelper.waitForElementToBeVisible(this.driver, Locators.ProductListPage.PRODUCT_SORTED_LIST_LABEL);

        if (!ascending){
            // Which means descending => High To Low
            productSortedListString = String.format(Locators.ProductListPage.PRODUCT_SORTED_LIST_STRING, Locators
                    .ProductListPage.PRICE_HIGH_TO_LOW);
            productSortedListLabel = getProductSortedListLabel();
        }

        if (productSortedListLabel.getText().equals(productSortedListString))
            return true;
        else
            return false;
    }

    /**
     * Returns Product Link for element in the result List
     * @param index : Index of Element in List (Zero being first element in list)
     * @return Webelement (link to product in the list)
     */
    private WebElement getProductResultLinkAt(int index){

        scrollToElement(getProductElementDivAt(index));
        WebElement element = syncHelper.waitForElementToBeVisible(this.driver, getProductElementLinkAt(index));
        return element;
    }

    private Select getSortByDropDown(){
        return new Select(driver.findElement(By.xpath(Locators.ProductListPage.SORT_BY)));
    }

    private WebElement getProductSortedListLabel(){
        return driver.findElement(By.xpath(Locators.ProductListPage.PRODUCT_SORTED_LIST_LABEL));
    }

    private WebElement getProductElementDivAt(int index){
        return driver.findElement(By.xpath(String.format(Locators.ProductListPage
                .PRODUCT_RESULT_DIV, index)));
    }
    private WebElement getProductElementLinkAt(int index){
        return driver.findElement(By.xpath(String.format(Locators.ProductListPage
                .PRODUCT_RESULT_LINK, index)));
    }

}
