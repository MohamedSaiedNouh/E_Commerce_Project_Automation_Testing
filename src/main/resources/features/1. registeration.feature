@RegressionTesting
Feature: Registration Functionality

  Scenario: User registers with valid data
    When user navigates to the Registration page
    And user enters "Mohamed" as firstname, "Nouh" as lastname, "ty@gmail.com" as an Email, "Freelance" as a company and "1234567" as a password
    And user clicks on REGISTER button
    Then user could Register into system successfully
    And user is directed to homepage