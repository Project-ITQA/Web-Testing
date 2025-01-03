Feature: Edit Job

  Background:
    #login to Application
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

    #Add job
    Given User is on the Job List View page
    And User clicks on the Add button in job management
    And User is navigated to the Add Job page
    And User fills the job Title "Senior Manager - Finance"
    When User clicks the submit button in job management
    Then User is directed to the Job List View page
    Then User can see the job "Senior Manager - Finance" listed

  Scenario Outline: Edit the job title

    Given User can see "<jobTitle>" in  Edit JobList Table
    When User clicks the Edit button of "<jobTitle>"
    And User is navigated to the Edit Job page
    And User edits the  job title field to "<newJobTitle>"
    And  User clicks the Edit page Submit button in job management
    Then User is directed to the Job List View page
    And User can see Edited job "<newJobTitle>" is listed

    Examples:

      | jobTitle                  | newJobTitle  |
      | Senior Manager - Finance  | CEO          |