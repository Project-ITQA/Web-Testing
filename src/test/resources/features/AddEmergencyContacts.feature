Feature: Add Emergency Contacts in My Info

  Background: User is logged in
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: User successfully adds emergency contact by filling required values with valid input
    Given the user navigates to the "My Info" tab
    Then the user should be on the My Info page
    Given the user navigates to "Emergency Contacts" section
    Then the user should be on the "Emergency Contacts" section
    When the user clicks on the "Add" button in "Assigned Emergency Contacts" space
    Then the user should be on the "Save Emergency Contact" section
    When the user enter the emergency contact details by typing values - "Name:Kamal, Relationship:Father, Mobile:0112536425"
    And the user clicks on the "Save" button
    Then a toast with "Success" message should be displayed
    And the user should see a record with "Kamal"

  Scenario: User tries to add emergency contact without filling all required values
    Given the user navigates to the "My Info" tab
    Then the user should be on the My Info page
    Given the user navigates to "Emergency Contacts" section
    Then the user should be on the "Emergency Contacts" section
    When the user clicks on the "Add" button in "Assigned Emergency Contacts" space
    Then the user should be on the "Save Emergency Contact" section
    When the user enter the emergency contact details by typing values - "Name:Kamal, Relationship:Father"
    And the user clicks on the "Save" button
    Then the user should see input validation error messages

  Scenario: User tries to add emergency contact by filling required values with invalid input
    Given the user navigates to the "My Info" tab
    Then the user should be on the My Info page
    Given the user navigates to "Emergency Contacts" section
    Then the user should be on the "Emergency Contacts" section
    When the user clicks on the "Add" button in "Assigned Emergency Contacts" space
    Then the user should be on the "Save Emergency Contact" section
    When the user enter the emergency contact details by typing values - "Name:123, Relationship:555, Mobile:0112536425"
    And the user clicks on the "Save" button
    Then the user should see input validation error messages
    And the user should see a record with "Kamal"


