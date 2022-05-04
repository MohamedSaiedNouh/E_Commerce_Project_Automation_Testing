@RegressionTesting
Feature: Create an order Functionality
  Scenario: Logged user could create successful Order
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user searches for "Lumia"
    And user clicks on ADD TO CART for adding product to cart
    And user selects a category for example "Electronics" then hover and open sub-Category for example "Others"
    And user clicks on ADD TO CART for adding product to cart
    And user clicks on shopping cart
    And user checks the terms of service and clicks on CHECKOUT
    And user selects Egypt as country , Other as State then enters "Cairo" as City , "New Cairo" as Address 1 , "12345" as Postal Code , "12345678910" as Phone Number , "0123456" as Fax Number
    And user selects shipping method
    And user selects payment method
    And user enters payment information , "Mohamed Saied" as Card holder name , "2222420000001113" as Card number , "789" as CC
    And user clicks on CONFIRM
    Then user could successfully make an order
