Feature: Add Job

  Background:
    # Login to Application
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario Outline: Add Job after filling all mandatory fields

    Given User is on the Job List View page
    When User clicks on the Add button in job management
    And User is navigated to the Add Job page
    And User fills the job Title "<jobTitle>"
    And User clicks the submit button in job management
    Then User is directed to the Job List View page
    And User can see the job "<jobTitle>" listed

    Examples:

      | jobTitle                    |
      | Senior Manager - Delivery    |
