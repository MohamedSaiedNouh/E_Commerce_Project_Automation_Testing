@RegressionTesting
Feature: Adding Products Wishlist Functionality
  Scenario: Logged user could add different products to Wishlist
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user searches for "HTC"
    And user clicks on Add to wishlist for adding product 1 to wishlist
    And user selects a category for ex. Computers then hover and open sub-Category for ex. Software
    And user clicks on Add product to wishlist for adding product 2 to wishlist
    And user clicks on wishlist
    Then user should find the selected products in the wishlist section