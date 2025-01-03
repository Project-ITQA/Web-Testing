Feature: Employee Management

  Background: User is logged in as an Admin
    Given user is logged in as an Admin

  Scenario Outline: Add a new employee successfully
    Given user navigates to the Add Employee page
    When user enters valid employee details "<First Name>" and "<Last Name>" and "<Emp ID>"
    And user saves the new employee
    Then user should see the employee "<Full Name>" in the employee list

    Examples:
      | First Name | Last Name    | Full Name           |  Emp ID |
      | Yukthi     | Hettiarachchi | Yukthi Hettiarachchi | 7511 |
#      | Alex       | Johnson      | Alex Johnson        |
#      | Maria      | Gonzalez     | Maria Gonzalez      |

  Scenario Outline: Prevent saving invalid employee names
    Given user navigates to the Add Employee page
    When user enters invalid employee details "<First Name>" and "<Last Name>" and "<Emp ID>"
    And user saves the new employee
    Then user should not be redirected to employee details page

    Examples:
      | First Name | Last Name |  Emp ID |
      | 1111       | 2222      | 75112 |


  Scenario Outline: Add a new employee with login details successfully
    Given user navigates to the Add Employee page
    When user enters valid employee details "<First Name>" and "<Last Name>" and "<Emp ID>"
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
      | First Name | Last Name | Emp ID    | Full Name           | Username  | Password |
      | John       | Doe       | 751123      | John Doe           | johdzxcsn.doe4fs3xzsad  | Password123 |



  Scenario Outline: Delete an employee
    Given user navigates to the Add Employee page
    When user enters valid employee details "<First Name>" and "<Last Name>" and "<Emp ID>"
    And user saves the new employee
    Then user should see the employee "<Full Name>" in the employee list
    Then user navigate to Employee List tab
    And user search for "<Emp ID>" employee
    Then user get the serch results
    And user delete the employee
    Then user click yes in pop-up
    And user get No Records Found on the table


    Examples:
      | First Name | Last Name | Emp ID    | Full Name           |
      | John       | Doe       |7511233    | John Doe           |