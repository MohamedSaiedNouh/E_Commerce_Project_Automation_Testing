@RegressionTesting

Feature: Currency Switch Functionality
  Scenario: Logged User could switch between currencies US-Euro
    Given user is already logged with "ty@gmail.com" and "1234567"
    When user selects Euro from Currencies List
    Then user could switch from USD to Euro