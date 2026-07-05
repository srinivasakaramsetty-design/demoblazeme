Feature: Home Page Functionality

Scenario: Verify user lands on home page after login

  Given User launches the DemoBlaze application
  When User clicks on Login menu
  And User logs in using Excel data
  Then User should see welcome message with username
  And User should see product list displayed