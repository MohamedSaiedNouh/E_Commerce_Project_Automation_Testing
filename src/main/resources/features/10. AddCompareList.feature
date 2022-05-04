@RegressionTesting
Feature: Compare between products Functionality
  Scenario: Logged user could add different products to compare list
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user searches for "laptop"
    And user clicks on Add to compare list to add two products into compare list
    And  user clicks on compare list
    Then user should find the selected products in the compare list section