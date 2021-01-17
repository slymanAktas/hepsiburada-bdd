@ui @end_to_end
Feature: End To End Payment Test
  Background:
    Given Buyer sign up to site then logs in
    Then Buyer should been registered successfully

  Scenario: Buy product via passing through all steps
    When Buyer goes category page which defined below
      | rootCategory | subCategory    |
      | DRESSES      | SUMMER DRESSES |
    And Buyer adds random product to basket from categories
    And First product should been added to basket successfully
    And Buyer has searched for "Summer"
    And Buyer adds random product to basket from search results
    And Second product should been added to basket successfully
    And Buyer chooses an address
    And Buyer accepts cargo option and terms of service
    When Buyer chooses payment type then complates payment
    Then Buyer should see the transaction on Order History And Details page successfully




