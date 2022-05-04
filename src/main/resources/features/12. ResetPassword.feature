@RegressionTesting

Feature: Reset Password Functionality

  Scenario: User reset reset his/her password
    When user navigates to the login page and clicks on Forgot password
    And user enters "ty@gmail.com" his/her email address
    And user clicks on RECOVER button
    Then user receives an Email with instructions has been sent to you