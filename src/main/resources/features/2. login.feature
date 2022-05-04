@RegressionTesting

Feature: Login Functionality

  Scenario: User logins with valid Email and Password
    When user navigates to the login page
    And user enters "ty@gmail.com" as an Email and "1234567" as password
    And user clicks on LOGIN button
    Then user could login into system successfully then user is directed to homepage

