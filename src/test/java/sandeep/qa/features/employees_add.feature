Feature: Add new employee

  Scenario: New Employee can be added
    Given I am on employees page
    When I click the Create button
    And I enter employee details
    And I save the Employee
    Then the list of employees should be displayed
    And I should see the employee created