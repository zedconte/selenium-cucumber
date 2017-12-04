package com.sits.amz;

import com.sits.amz.pages.HomePage;
import com.sits.amz.pages.ProductDetailsPage;
import com.sits.amz.pages.ProductListPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductSearch extends TestNgTestBase {

    private final static String productKeyWord = "Nikon";
    private final static String expectedProductTitle = "Nikon D3X";

  @Test
  public void testProductSearchByKeyWord() {
      driver.get(baseUrl);
      HomePage homePage = PageFactory.initElements(driver, HomePage.class);
      ProductListPage productListPage = homePage.search_product(productKeyWord);
      productListPage.sortByPrice();
      ProductDetailsPage productDetailsPage = productListPage.openProductDetailsAt(1);
      String productTitle = productDetailsPage.getProductTitle();
      Assert.assertTrue(productTitle.contains(expectedProductTitle));
  }
}
