# README.md
Sample code for Testing Amazon Product Search using Selenium

## Steps
- Goto Amazon.com home page
- Search Nikon and sort results from highest price to slowest.
- Select second product and click it for details.
- From details check (verify with assert) that product topic contains text “Nikon D3X”

## Implementation

Project is generated using [ru.stqa.selenium](https://mvnrepository.com/artifact/ru.stqa.selenium/webdriver-testng-archetype/4.2) archetype.

This helps in setting up basic maven dependencies, configuration file using property files & out of box WebDriver pooler to manager webdrivers.

NOTE:- Project structure is **heavily** modified to suite my style of code structuring.

### Branches

* There are two branches --
    * Master
    * Cucumber

* Master branch implements Selenium test using standard PageObjects and TestNG test method. 
* Cucumber strives to implement BDD style of testing. You can refer to [ProductSearch.feature](https://github.com/mrudulp/amz_search/blob/cucumber/src/test/java/com/sits/amz/features/ProductSearch.feature) for more info

Both branches closely shadow each other viz. Checkpoints closely match requirements written in [ProductSearch.feature](https://github.com/mrudulp/amz_search/blob/cucumber/src/test/java/com/sits/amz/features/ProductSearch.feature) 

## Environment

This code is tested against --
* Jdk build 1.8.0_60-b27 
* chromedriver 2.33.506106
* OS X (El Capitan) 10.11.6



