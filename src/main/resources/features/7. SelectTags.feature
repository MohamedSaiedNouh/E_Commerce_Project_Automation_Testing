@RegressionTesting
  Feature: Select Tags Functionality
    Scenario: Logged user could select different tags
      Given user is already logged with "ty@gmail.com" and "1234567"
      And user selects any category for example "Apparel" then hover and open sub-Category for example "Shoes"
      When user selects "apparel" tag for example from popular tags
      Then users could directed to the product tagged page