Feature: Multiple Product Purchase

Scenario: Add multiple products

Given User is logged in
When User adds multiple products using Excel data
Then Products should be added to cart