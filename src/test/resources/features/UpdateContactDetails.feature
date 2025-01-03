Feature: Update Contact Details In My Info

  Background: User is logged in
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: User successfully updates contact details with valid input
    When the user navigates to the "My Info" tab
    Then the user should be on the My Info page
    When the user navigates to "Contact Details" section
    Then the user should be on the "Contact Details" section
    When the user updates their contact details by typing values - "City:Kandy, State/Province:Central, Zip/Postal Code:15661"
    And the user updates their contact details by selecting options with values - "Country:Sri Lanka"
    And the user clicks on the "Save" button
    Then a toast with "Success" message should be displayed

  Scenario: User tries to update contact details with invalid input
    When the user navigates to the "My Info" tab
    Then the user should be on the My Info page
    When the user navigates to "Contact Details" section
    Then the user should be on the "Contact Details" section
    When the user updates their contact details by typing values - "City:15145, State/Province:64655, Zip/Postal Code:test"
    And the user clicks on the "Save" button
    Then the user should see input validation error messages

