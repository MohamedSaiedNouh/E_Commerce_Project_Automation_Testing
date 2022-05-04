@RegressionTesting

Feature: Categories Selection Functionality
  Scenario: Logged user could select different Categories
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user selects any category for example "Apparel" then hover and open sub-Category for example "Shoes"
    Then user could navigate to the landing page of this sub-Category "Shoes"