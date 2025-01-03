Feature: Create a New Claim

  Background:
    Given user is logged in as an Admin

  Scenario Outline: Create a new claim with all mandatory fields filled
    Given the user is on the Claims Page
    When the user clicks the Submit Claim button
    And the user is navigated to the Submit Claim page
    And the user selects the Event "<Event>"
    And the user selects the Currency "<Currency>"
    And the user enters Remarks "<Remarks>"
    And the user clicks the Create button
    Then the user is directed to the View Claim page
    And the user should see the claim details Event "<Event>" and Currency "<Currency>" and Remarks "<Remarks>"

    Examples:
      | Event                 | Currency             | Remarks        |
      | Accommodation         | Sri Lanka Rupee      | Hotel Stay     |
      | Medical Reimbursement | United States Dollar | Hospital Bill  |

  Scenario Outline: Create a new claim without filling mandatory fields
    Given the user is on the Claims Page
    When the user clicks the Submit Claim button
    And the user is navigated to the Submit Claim page
    And the user selects the Event "<Event>"
    And the user enters Remarks "<Remarks>"
    And the user clicks the Create button
    Then User can see the required message under the currency field

    Examples:
      | Event                 | Remarks          |
      | Accommodation         | Hotel Stay       |
      | Medical Reimbursement | Hospital Visit   |
