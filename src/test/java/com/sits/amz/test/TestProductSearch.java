package com.sits.amz.test;


import com.sits.amz.common.TestNgTestBase;
import com.sits.amz.pages.HomePage;
import com.sits.amz.pages.ProductDetailsPage;
import com.sits.amz.pages.ProductListPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductSearch extends TestNgTestBase {

    private final static String productKeyWord = "Nikon";
    private final static String expectedProductTitle = "Nikon D3X";
    private final static int secondProductIndex = 1;

    /**
     * This test tests Product Search By Keyword
     */
    @Test
    public void testProductSearchByKeyWord() {
        driver.get(baseUrl);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProductListPage productListPage = homePage.search_product(productKeyWord);
        productListPage.sortByPrice();;
        Assert.assertTrue(productListPage.verifyProductListIsSortedByPrice(false));
        ProductDetailsPage productDetailsPage = productListPage.openProductDetailsAt(secondProductIndex);
        String productTitle = productDetailsPage.getProductTitle();
        Assert.assertTrue(productTitle.contains(expectedProductTitle));
    }
}
