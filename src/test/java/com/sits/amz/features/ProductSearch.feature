@ProductSearch
Feature: Search Product
  As a user of Amazon
  I want to be able to search for product using keywords

  Background: User navigates to Amazon home page
    Given I am on "Amazon" page on URL "http://www.amazon.com"
    Then I should see Search box

  Scenario: Product Details
    When I fill in "Nikon" and press Search button
    And I get List of "Nikon" Products
    And I Select Option "Price: High to Low"
    And I Select Second Product in List
    Then I can see Product Title Containing "Nikon D3X"