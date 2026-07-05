Feature: Product Selection

Scenario: Add single product

Given User is logged in
When User selects a product
And User adds the product to cart
Then Product should be added successfully