Feature: User login

  Scenario: USer with correct credentials should be able to login
    Given the login page
    When I enter correct credentials and login
    Then I should be logged in
    And the list of employees should be displayed