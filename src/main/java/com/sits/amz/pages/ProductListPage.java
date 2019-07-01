package com.sits.amz.pages;

import com.sits.amz.common.SyncHelper;
import com.sits.amz.locators.Locators;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Mrudul Pendharkar.
 */
public class ProductListPage extends Page{

    @FindBy(xpath = Locators.ProductListPage.PRODUCT_KW)
    @CacheLookup
    private WebElement productListKeyword;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets Text of Product List Keyword
     * @return keyword text
     */
    public String getProductListKeywordText(){
        return this.productListKeyword.getText();
    }

    /**
     * Checks if optionText is available from list of options
     * @param optionText : String specifying Sorting option
     * @return True if optionText is available else False
     */
    public boolean containsOption(String optionText){
        Select sort_by_drop_down = getSortByDropDown();
        List<WebElement> options = sort_by_drop_down.getOptions();
        for (WebElement option : options) {
            if (option.getText().toLowerCase().equals(optionText.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts Result by Option Passed as Parameter
     * @param optionText : String specifying Sorting option
     */
    public void sortBy(String optionText){
        Select sort_by_drop_down = getSortByDropDown();
        List<WebElement> options = sort_by_drop_down.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
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
    public boolean verifyProductListIsSortedByPrice(boolean ascending) throws NotImplementedException {
        String productSortedListString = "";
        WebElement productSortedListLabel = null;

        // Verifying Element is visible
        SyncHelper.waitForElementToBeVisible(this.driver, Locators.ProductListPage.PRODUCT_SORTED_LIST_LABEL);

        if (!ascending){
            // Which means descending => High To Low
            productSortedListString = String.format(Locators.ProductListPage.PRODUCT_SORTED_LIST_STRING, Locators
                    .ProductListPage.PRICE_HIGH_TO_LOW);
            productSortedListLabel = getProductSortedListLabel();
        }
        else {
            throw new NotImplementedException("Other Sorting Options Not Implemented.");
        }

        if (new StringBuilder(productSortedListLabel.getText().concat(" ")).append(Locators.ProductListPage.PRICE_HIGH_TO_LOW).toString().equals(productSortedListString))
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
        WebElement element = SyncHelper.waitForElementToBeVisible(this.driver, getProductElementLinkAt(index));
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
