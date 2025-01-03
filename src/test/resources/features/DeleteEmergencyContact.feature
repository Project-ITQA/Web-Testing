Feature: Delete Emergency Contacts in My Info

  Background: User is logged in
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: User successfully deletes an emergency contact
    Given the user navigates to the "My Info" tab
    Then the user should be on the My Info page
    Given the user navigates to "Emergency Contacts" section
    Then the user should be on the "Emergency Contacts" section
    Given the user clicks on the "Add" button in "Assigned Emergency Contacts" space
    Then the user should be on the "Save Emergency Contact" section
    Given the user enter the emergency contact details by typing values - "Name:Sunil, Relationship:Uncle, Mobile:0112536425"
    And the user clicks on the "Save" button
    Then the user should see a record with "Sunil"
    When the user clicks on the "Delete" icon button in the row with "Sunil"
    Then the user should see a prompt asking "Are you Sure?"
    When the user clicks on the "Yes, Delete" button
#    Then a toast with "Success" message should be displayed
    And the user should not see a record with "Sunil"
