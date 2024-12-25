Feature: Employee Management

  Scenario: Add a new employee successfully
    Given user is on the Add Employee page
    When user enters valid employee details
    And user saves the new employee
    Then user should see the employee in the employee list
