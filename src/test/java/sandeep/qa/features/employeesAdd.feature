Feature: Add new employee

  Scenario: New Employee can be added
    Given I am on employees page
    When I click the Create button
    And I enter employee details
    And I add the Employee
    Then the list of employees should be displayed
    And I should see the employee created

  Scenario: New employee cannot be added with an invalid date
    Given I am on employees page
    When I click the Create button
    And I enter employee details with invalid date
    And I add the Employee
    Then the start date cannot be empty dialog should be displayed

  Scenario: New employee is not added if the Cancel button is clicked
    Given I am on employees page
    When I click the Create button
    And I enter employee details
    And I click the Cancel button
    Then I should not see the employee
