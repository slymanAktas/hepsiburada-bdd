@api @clients
Feature: Clients test
  Scenario: Get Clients
    When Get all clients
    Then User should see "java" in the client languages list