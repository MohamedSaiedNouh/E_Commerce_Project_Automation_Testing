@RegressionTesting

Feature: Color Filter Functionality
  Scenario: Logged user could filter with color
    Given user is already logged with "ty@gmail.com" and "1234567"
    And user selects any category for example "Apparel" then hover and open sub-Category for example "Shoes"
    When user could select any color from colors pane
    Then users could filter with selected color