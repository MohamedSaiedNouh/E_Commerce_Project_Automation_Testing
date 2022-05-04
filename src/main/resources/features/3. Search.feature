@RegressionTesting

Feature: Searching Functionality

  Scenario: logged user should be able to search for any product
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user searches for "Lumia"
    Then user could navigate to product page

