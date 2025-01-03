Feature: Add User

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: Add User by Entering Valid Values
    Given User is on the Admin User Management page
    And User clicks on the Add button in user management
    And User is navigated to the Add User page
    And User fills the user role "Admin" and employee name "James Butler" and status "Enabled" and username "JamesBu" and password "JamesB@12" and confirm password as "JamesB@12"
    When User clicks the submit button in user management
    Then User is directed to the view user page
    Then User can see user "JamesBu"

  Scenario: Add User Without Filling Required Fields
    Given User is on the Admin User Management page
    And User clicks on the Add button in user management
    And User is navigated to the Add User page
    And User fills the user role "Admin" and status "Enabled" and username "JamesBut" and password "JamesB@123" and confirm password as "JamesB@123"
    When User clicks the submit button in user management
    Then User is getting the error under the employee Name field

  Scenario: Add User Without Filling Confirm Password Field
    Given User is on the Admin User Management page
    And User clicks on the Add button in user management
    And User is navigated to the Add User page
    And User fills the user role "Admin" and employee name "James Butler" and status "Enabled" and username "JamesBu" and password as "JamesB@12"
    When User clicks the submit button in user management
    Then User is getting the error under the Confirm Password field
