Feature: Delete Job

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
    And User fills the job Title "Senior Manager - Sales"
    When User clicks the submit button
    Then User is directed to the Job List View page
    Then User can see the job "Senior Manager - Sales" listed

  Scenario: Delete Job

    Given User can see "Senior Manager - Sales" in JobList Table
    When  user clicks on the Delete button of "Senior Manager - Sales"
    When User clicks on the confirm Button
    Then User cannot see "Senior Manager - Sales" in JobList table