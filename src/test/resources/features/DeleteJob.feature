Feature: Delete Job

  Background:
    # Login to Application
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

    # Add job
    Given User is on the Job List View page
    And User clicks on the Add button in job management
    And User is navigated to the Add Job page
    And User fills the job Title "Senior Manager - Sales"
    When User clicks the submit button in job management
    Then User is directed to the Job List View page
    Then User can see the job "Senior Manager - Sales" listed

  Scenario Outline: Delete Job

    Given User can see "<jobTitle>" in JobList Table
    When user clicks on the Delete button of "<jobTitle>"
    When User clicks on the confirm Button in job management
    Then User cannot see "<jobTitle>" in JobList table

    Examples:

      | jobTitle                  |
      | Senior Manager - Sales    |
