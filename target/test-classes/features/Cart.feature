Feature: Cart

Scenario: Verify cart

Given Products are added to cart
When User opens cart
Then Product details should be displayed

Scenario: Remove product

Given Product is available in cart
When User removes the product
Then Product should be removed