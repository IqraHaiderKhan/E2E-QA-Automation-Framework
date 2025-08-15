
Feature: Add item to cart
  As a shopper
  I want to add an item to my cart
  So that I can proceed to checkout

  Scenario: Add first search result to cart
    Given I am on the home page
    When I search for "computer"
    And I add the first result to the cart
    Then I should see the cart page or a cart indicator
