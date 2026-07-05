Feature: Place Order

Scenario: Purchase Product

Given User is on cart page
When User places order using Excel data
Then Purchase confirmation should be displayed