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

  Scenario Outline: Prevent saving invalid employee names
    Given user navigates to the Add Employee page
    When user enters invalid employee details "<First Name>" and "<Last Name>"
    And user saves the new employee
    Then user should not be redirected to employee details page
    And user should not see the invalid employee "<Full Name>" in the employee list

    Examples:
      | First Name | Last Name | Full Name |
      | 1111       | 2222      | 1111 2222 |


  Scenario Outline: Add a new employee with login details successfully
    Given user navigates to the Add Employee page
    When user enters valid employee details "<First Name>" and "<Last Name>"
    And user toggles create login details
    And user enters login details "<Username>" and "<Password>"
    And user toggles status Enabled
    And user saves the new employee
    Then user should see the employee "<Full Name>" in the employee list
    When user logs out
    When user enters "<Username>" as username
    And user enters "<Password>" as password
    Then user should be able to login

    Examples:
      | First Name | Last Name    | Full Name           | Username  | Password |
      | John       | Doe          | John Doe           | johdzxcsn.doe4fs3xzsad  | Password123 |