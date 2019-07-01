package com.sits.amz.stepdefs;


import com.sits.amz.common.TestBase;
import com.sits.amz.pages.HomePage;
import com.sits.amz.pages.Page;
import com.sits.amz.pages.ProductDetailsPage;
import com.sits.amz.pages.ProductListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Mrudul Pendharkar.
 */
public class StepDefinitions extends TestBase {

    private TestBase testBaseRef;
    private Page currentPage;
    private final static int secondProductIndex = 1;

    public StepDefinitions(TestBase testBaseRef) {
        this.testBaseRef = testBaseRef;
    }

    @Given("^I am on \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    public void i_am_on_page_on_URL(String websiteName, String websiteAddress) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        testBaseRef.driver.get(websiteAddress);
    }

    @Then("^I should see Search box$")
    public void i_should_see_Search_box() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = PageFactory.initElements(testBaseRef.driver, HomePage.class);
        this.currentPage = homePage;
        Assert.assertTrue(homePage.isSearchBoxVisible());
    }

    @When("^I fill in \"(.*)\" and press Search button$")
    public void iFillInAndPressSearchButton(String productKeyword) throws Throwable {
        HomePage homePage = (HomePage)this.currentPage;
        this.currentPage = homePage.search_product(productKeyword);
    }

    @Then("^I get List of \"(.*)\" Products$")
    public void i_get_List_of_Products(String productKeyword) throws Throwable {
        ProductListPage productListPage = (ProductListPage) this.currentPage;
        Assert.assertTrue(productListPage.getProductListKeywordText().toLowerCase().contains(productKeyword
                .toLowerCase()));
    }

    @Then("^I See Option \"(.*)\"$")
    public void i_See_Option(String option) throws Throwable {
        ProductListPage productListPage = (ProductListPage) this.currentPage;
        Assert.assertTrue(productListPage.containsOption(option));
    }

    @When("^I Select Option \"(.*)\"$")
    public void i_Select_Option(String option) throws Throwable {
        ProductListPage productListPage = (ProductListPage) this.currentPage;
        productListPage.sortBy(option);
    }

    @When("^I Select Second Product in List$")
    public void i_Select_Second_Product_in_List() throws Throwable {
        ProductListPage productListPage = (ProductListPage) this.currentPage;
        this.currentPage = productListPage.openProductDetailsAt(secondProductIndex);
    }

    @Then("^I can see Product Title Containing \"([^\"]*)\"$")
    public void i_can_see_Product_Title_Containing(String productName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ProductDetailsPage productDetailsPage = (ProductDetailsPage) this.currentPage;
        String productNameStripped = productName.replaceAll("^\"|\"$", "");
        Assert.assertTrue(productDetailsPage.getProductTitle().contains(productNameStripped));
    }


}