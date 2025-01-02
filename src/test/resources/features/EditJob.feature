Feature: Edit Job

  Background:
    #login to Application
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login

    #Add job
    Given User is on the Job List View page
    And User clicks on the Add button
    And User is navigated to the Add Job page
    And User fills the job Title "Senior Manager - Finance"
    When User clicks the submit button
    Then User is directed to the Job List View page
    Then User can see the job "Senior Manager - Finance" listed

  Scenario: Edit the job title
    Given User can see "Senior Manager - Finance" in  Edit JobList Table
    When User clicks the Edit button of "Senior Manager - Finance"
    And User is navigated to the Edit Job page
    And User edits the  job title field to "CEO"
    And  User clicks the Edit page Submit button
    Then User is directed to the Job List View page
    And User can see Edited job "CEO" is listed