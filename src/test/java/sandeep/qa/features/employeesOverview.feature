Feature: Overview page of employees

  Scenario: Overview page should have correct elements displayed
    Given I am on employees page
    Then my username should be displayed
    And the logout button should be displayed
    And the Create button should be enabled
    And the Edit button should be disabled
    And the Delete button should be disabled