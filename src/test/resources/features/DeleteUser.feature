Feature: Delete User

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: Delete user
    Given User is on the Admin User Management page
    And User clicks on the Add button in user management
    And User is navigated to the Add User page
    And User fills the user role "Admin" and employee name "John Doe" and status "Enabled" and username "JohnAk" and password "Ran@123" and confirm password as "Ran@123"
    When User clicks the submit button in user management
    Given User is on the Admin User Management page
    Then User can see user "JohnAk"
    When User clicks on the Delete button of "JohnAk"
    When User clicks on the confirm button in user management
    Then User cannot see "JohnAk"
