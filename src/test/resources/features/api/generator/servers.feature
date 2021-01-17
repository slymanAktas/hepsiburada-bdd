@api @servers
Feature: Servers test
  Scenario: Get Servers
    When Get all servers
    Then User should see "go-server" in the server languages list