Feature: DemoBlaze Product and Cart Functionality

Background:
  Given User launches the DemoBlaze application
  When User logs in using Excel data
  Then User should be logged in successfully

Scenario: Verify user lands on home page after login
  Then User should see welcome message with username
  And User should see product list displayed

Scenario: Verify product details after selecting a product
  When User clicks on "Samsung galaxy s6" product
  Then User should see the product details page
  And User should verify the product name
  And User should verify the product price
  And User should verify the product description

Scenario: Verify user can add product to cart successfully
  When User clicks on "Samsung galaxy s6" product
  And User clicks on "Add to cart" button
  And User accepts the alert
  And User should see the product added to cart successfully
  
  Scenario: Verify user can purchase product successfully
  When User clicks on "Samsung galaxy s6" product
  And User clicks on "Add to cart" button
  And User accepts the alert
  And User should see the product added to cart successfully
  And User clicks on Place Order button
  And User enters order details "Srinivas", "India", "Hyderabad", "1234567890123456", "12", "2026"
  And User clicks on Purchase button
  Then User should see order confirmation message
  And User accepts confirmation alert
  	
  
