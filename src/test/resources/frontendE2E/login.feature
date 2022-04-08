@Smoke
Feature: Login
  The user should be able to login

  Scenario: Login with invalid credentials
    Given I am in the test login page
    When I insert an invalid credentials
    Then I should see the invalid credentials message