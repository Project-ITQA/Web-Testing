Feature: Search a Claim

  Background:
    # Login to the system
    Given user is logged in as an Admin

    # Add a new claim
    Given the user is on the Claims Page
    When the user clicks the Submit Claim button
    And the user is navigated to the Submit Claim page
    And the user selects the Event "Medical Reimbursement"
    And the user selects the Currency "United States Dollar"
    And the user enters Remarks "Hospital Stay"
    And the user clicks the Create button
    Then the user is directed to the View Claim page
    And the user should see the claim details Event "Medical Reimbursement" and Currency "United States Dollar" and Remarks "Hospital Stay"

  Scenario Outline: Search a claim
    Given the user is on the Claims Page
    And the user selects the Event "<Event>" in the search field
    And the user selects the Status "<Status>" in the search field
    And the user selects the reference number in the search field
    When the user clicks the search button
    Then the user should only see the claim details Event "<Event>" and Currency "<Currency>" and Remarks "<Remarks>" in the search result

    Examples:
      | Event                 | Status    | Currency             | Remarks         |
      | Medical Reimbursement | Initiated | United States Dollar | Hospital Stay   |
