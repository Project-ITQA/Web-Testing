Feature: Delete Candidate

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: Delete Candidate
    Given User is on the Recruitment Candidates page
    And User clicks on the Add button
    And User is navigated to the Add Candidate page
    And User fills the first name "Nuwan" and last name "Kumara" and email as "nuwan@gmail.com"
    When User clicks the submit button
    Then User is directed to the view candidate page
    Then User can see candidate "Nuwan" "Kumara"
    Given User is on the Recruitment Candidates page
    Given User can see "Nuwan" "Kumara" in Candidates table
    When User clicks on the Delete button of "Nuwan" "Kumara"
    When User clicks on the confirm button
    Then User cannot see "Nuwan" "Kumara" in candidates table