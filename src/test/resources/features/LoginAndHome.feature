Feature: Login Functionality

Scenario: Verify user can login using Excel data

Given User launches the DemoBlaze application
When User logs in using Excel data
Then User should be logged in successfully

Scenario: Verify user lands on home page after login

  Given User launches the DemoBlaze application
  When User logs in using Excel data
  Then User should see welcome message with username
  And User should see product list displayed