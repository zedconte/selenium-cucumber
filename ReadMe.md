# README.md
Sample code for Testing Amazon Product Search using Selenium

## Steps
- Goto Amazon.com home page
- Search Nikon and sort results from highest price to slowest.
- Select second product and click it for details.
- From details check (verify with assert) that product topic contains text “Nikon D3X”

## Implementation

In the spirit of not wanting to reinvent wheel & learning from best practices from opensource community out there, this project is generated using [ru.stqa.selenium](https://mvnrepository.com/artifact/ru.stqa.selenium/webdriver-testng-archetype/4.2) archetype.

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


## References

* [Maven Archetype](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)
* [TestNG, Cucumber, Maven](https://medium.com/agile-vision/cucumber-bdd-part-2-creating-a-sample-java-project-with-cucumber-testng-and-maven-127a1053c180)
* [Introduction to Cucumber & BDD with examples](https://automationrhapsody.com/introduction-to-cucumber-and-bdd-with-examples/)
* [Video Series on Introduction to Cucumber & Selenium](https://www.youtube.com/watch?v=TUX7ntXlVkc&list=PL6tu16kXT9PpteusHGISu_lHcV6MbBtA6)
