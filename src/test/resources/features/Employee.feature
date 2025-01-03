Feature: Employee Management

  Background: User is logged in as an Admin
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page
#    Given user is logged in as an Admin

  Scenario Outline: Add a new employee successfully
    Given user navigates to the Add Employee page
    When user enters valid employee details "<First Name>" and "<Last Name>" and "<Emp ID>"
    And user saves the new employee
    Then user should see the employee "<Full Name>" in the employee list

    Examples:
      | First Name | Last Name    | Full Name           |  Emp ID |
      | Yukthi     | Hettiarachchi | Yukthi Hettiarachchi | 819zd78cx |


  Scenario Outline: Prevent saving invalid employee names
    Given user navigates to the Add Employee page
    When user enters invalid employee details "<First Name>" and "<Last Name>" and "<Emp ID>"
    And user saves the new employee
    Then user should not be redirected to employee details page

    Examples:
      | First Name | Last Name |  Emp ID |
      | 1111       | 2222      | 819sd7z9cx  |


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
    Then user should be on dashboard page

    Examples:
      | First Name | Last Name | Emp ID    | Full Name           | Username  | Password |
      | John       | Doe       | 819q8zc0x      | John Doe           | jo1caszx.do  | Password123 |



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
      | John       | Doe       |819dc9z1x    | John Doe           |