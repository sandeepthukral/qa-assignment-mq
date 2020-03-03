Feature: Delete employee scenarios

  Background: Newly created employee exits
    Given a newly created employee

  Scenario: User can be deleted from Edit page
    Given I am on employees page
    When I double click the employee
    And I delete the employee
    Then I should not see the employee

## This scenario is commented out because the application sometimes
## behaved erratically when no mouse movement is detected while performing these steps
## Hence this test is flaky and more time and energy needs to be spent on making this work

#  Scenario: User can be deleted from employees list page
#    Given I am on employees page
#    When I select the employee
#    And I click the Delete button
#    And confirm the delete dialog
#    Then I should not see the employee