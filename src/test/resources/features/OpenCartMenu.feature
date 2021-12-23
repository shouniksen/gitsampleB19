Feature: Search and Place Order

Scenario: Search an Order
Given User is on Home Page
When User search "Phone"
And Add Item to cart
Then Item must be in cart