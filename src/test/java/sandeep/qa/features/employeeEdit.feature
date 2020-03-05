Feature: Edit employee details

  Background: Newly created employee exits
    Given a newly created employee

  Scenario: User should be able to update employee by double clicking the employee
    Given I am on employees page
    When I double click the employee
    And I update the employee with a new first and last name
    Then the list of employees should be displayed
    And I should see the updated employee name displayed

  Scenario: User should be able to update employee by using the Edit button
    Given I am on employees page
    When I select the employee
    And I click the Edit button
    And I update the employee with a new first and last name
    Then the list of employees should be displayed
    And I should see the updated employee name displayed


  ## This scenario could actually be a bug.
  ## When an invalid date is entered the update button should not dismiss the edit form
  ## The behavior should be the same as that for updating with an invalid email address below
  ## For now, I am keeping it as a test as I cannot decide whether this is a bug or not
  Scenario: Editing an employee with invalid start date will not update the start date
    Given I am on employees page
    And I double click the employee
    When I update the user with an invalid start date
    And I double click the employee
    Then the employee start date should remain unchanged

  Scenario: Editing an employee with invalid email will not let you update
    Given I am on employees page
    And I double click the employee
    When I update the user with an invalid email
    And I update the employee
    Then the email field is marked invalid
    And the employee is not updated

  Scenario: Clicking Back button will not update the user
    Given I am on employees page
    When I select the employee
    And I click the Edit button
    And I set new first and last name
    And I click the Back button
    Then I should see the original employee name displayed
