Feature: Search User

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login

  Scenario:
    Given User is on the Admin User Management page
    And User clicks on the Add button
    And User is navigated to the Add User page
    And User fills the user role "Admin" and employee name "Arvel Addison Deckow" and status "Enabled" and username "ArvelAdd" and password "Arv@123" and confirm password as "Arv@123"
    When User clicks the submit button
    Then User is directed to the view user page
    Given User is on the Admin User Management page
    When User types "ArvelAdd" in the search box
    When User clicks the Search button
    Then User can see user "ArvelAdd"

