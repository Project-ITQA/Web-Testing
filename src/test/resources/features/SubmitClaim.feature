Feature: Submit a New Claim

  Background:
    Given the user is on the OrangeHRM home page
    When the user logs in with username "Admin" and password "admin123"
    Then the user should be logged in successfully

  Scenario: Submit a new claim with all mandatory fields filled
    Given the user is on the Claims Page
    When the user clicks the Submit Claim button
    And the user is navigated to the Submit Claim page
    And the user selects the Event "Accommodation"
    And the user selects the Currency "Sri Lanka Rupee"
    And the user enters Remarks "Hotel Stay"
    And the user clicks the Create button
    Then the user is directed to the View Claim page
    And the user should see the claim details

