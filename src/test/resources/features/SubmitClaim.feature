Feature: Submit a New Claim

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login

  Scenario: Submit a new claim with all mandatory fields filled
    Given the user is on the Claims Page
    When the user clicks the Submit Claim button
    And the user is navigated to the Submit Claim page
    And the user selects the Event "Accommodation"
    And the user selects the Currency "Sri Lanka Rupee"
    And the user enters Remarks "Hotel Stay"
    And the user clicks the Create button
    Then the user is directed to the View Claim page
    And the user should see the claim details Event "Accommodation" and Currency "Sri Lanka Rupee" and Remarks "Hotel Stay"

  Scenario: Submit a new claim without filling mandatory fields
    Given the user is on the Claims Page
    When the user clicks the Submit Claim button
    And the user is navigated to the Submit Claim page
    And the user selects the Event "Accommodation"
    And the user enters Remarks "Hotel Stay"
    And the user clicks the Create button
    Then User can see the required message under the currency field


