package com.sits.amz.test;


import com.sits.amz.common.TestNgTestBase;
import com.sits.amz.pages.HomePage;
import com.sits.amz.pages.ProductDetailsPage;
import com.sits.amz.pages.ProductListPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductSearch extends TestNgTestBase {

    private final static String PRODUCT_KEY_WORD = "Nikon";
    private final static String EXPECTED_PRODUCT_TITLE = "Nikon D3X";
    private final static int SECOND_PRODUCT_INDEX = 1;
    private final static String PRICE_HIGH_TO_LOW = "Price: High to Low";

    /**
     * This test tests Product Search By Keyword
     */
    @Test
    public void testProductSearchByKeyWord() {
        driver.get(baseUrl);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.isSearchBoxVisible());

        ProductListPage productListPage = homePage.search_product(PRODUCT_KEY_WORD);
        Assert.assertTrue(productListPage.containsOption(PRICE_HIGH_TO_LOW));

        productListPage.sortBy(PRICE_HIGH_TO_LOW);
        Assert.assertTrue(productListPage.verifyProductListIsSortedByPrice(false));

        ProductDetailsPage productDetailsPage = productListPage.openProductDetailsAt(SECOND_PRODUCT_INDEX);
        String productTitle = productDetailsPage.getProductTitle();
        Assert.assertTrue(productTitle.contains(EXPECTED_PRODUCT_TITLE));
    }
}
