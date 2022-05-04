@RegressionTesting
Feature: Adding Products to Shopping Cart Functionality
  Scenario: Logged user could add different products to Shopping cart
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user searches for "Lumia"
    And user clicks on ADD TO CART for adding product to cart
    And user selects a category for example "Electronics" then hover and open sub-Category for example "Others"
    And user clicks on ADD TO CART for adding product to cart
    And user clicks on shopping cart
    Then user should find the selected products in the shopping cart section