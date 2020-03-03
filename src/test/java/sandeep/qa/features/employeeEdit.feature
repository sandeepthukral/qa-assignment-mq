Feature: Edit employee details

  Background: Newly created employee exits
    Given a newly created employee

  Scenario:
    Given I am on employees page
    When I double click the employee
    And I update the last name
    Then the list of employees should be displayed
    And I should see the updated name displayed

  Scenario:
    Given I am on employees page
    When I select the employee
    And I click the Edit button
    Then I should be redirected to the employee edit page

  Scenario: Editing an employee with invalid start date will not update the start date
    And I am on employees page
    And I double click the employee
    When I update the user with an invalid start date
    And I double click the employee
    Then the employee start date should remain unchanged
