Feature: Submit a Claim

  Background:
    # Login to the system
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login

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

  Scenario Outline: Add expenses and submit
    Given the user is directed to the View Claim page
    When the user clicks the Add Expenses button
    Then the add expenses modal should be displayed
    And the user selects the Expense Type "<ExpenseType>"
    And the user enters the Amount "<Amount>"
    And the user enters the Date "<Date>"
    And the user enters the Note "<Note>"
    And the user clicks the save button
    Then the user should see the expense details Expense Type "<ExpenseType>" and Amount "<Amount>" and Date "<Date>" and Note "<Note>"
    When the user clicks the Submit button
    Then the user should see the claim status as "Submitted"

    Examples:
      | ExpenseType       | Amount | Date       | Note  |
      | Planned Surgery   | 100    | 2025-02-01 | Meal  |
      | Transport         | 200    | 2024-01-02 | Taxi  |
      | Accommodation     | 300    | 2023-12-03 | Hotel |

    Scenario: Submit a claim without adding expenses
      Given the user is directed to the View Claim page
      When the user clicks the Submit button
      Then the user should see a required message under the Expenses field