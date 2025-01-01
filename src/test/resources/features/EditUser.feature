#Feature: Edit User
#
#  Background:
#    Given user is on home page
#    When user enters "Admin" as username
#    And user enters "admin123" as password
#    Then user should be able to login
#
#  Scenario: Edit User Correctly
#    Given User is on the Admin User Management page
#    And User clicks on the Add button
#    And User is navigated to the Add User page
#    And User fills the user role "Admin" and employee name "James  Butler" and status "Enabled" and username "JamesBu" and password "JamesB@12" and confirm password as "JamesB@12"
#    When User clicks the submit button
#    Then User is directed to the view user page
#    Then User can see candidate "James Butler"