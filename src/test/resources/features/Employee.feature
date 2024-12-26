Feature: Employee Management

  Background: User is logged in as an Admin
    Given user is logged in as an Admin

  Scenario Outline: Add a new employee successfully
    Given user navigates to the Add Employee page
    When user enters valid employee details "<First Name>" and "<Last Name>"
    And user saves the new employee
    Then user should see the employee "<Full Name>" in the employee list

    Examples:
      | First Name | Last Name    | Full Name           |
      | Yukthi     | Hettiarachchi | Yukthi Hettiarachchi |
#      | Alex       | Johnson      | Alex Johnson        |
#      | Maria      | Gonzalez     | Maria Gonzalez      |
