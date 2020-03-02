Feature: User login

  Scenario: User with correct credentials should be able to login
    Given the login page
    When I enter correct credentials and login
    Then I should be logged in
    And the list of employees should be displayed

  Scenario: User with incorrect credentials cannot login
    Given the login page
    When I enter random credentials and login
    Then I should not be logged in
    And and invalid credentials message should be displayed

  Scenario: User should be able to logout
    Given the login page
    When I enter correct credentials and login
    And I logout
    Then I should not be logged in