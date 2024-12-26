Feature: Manage Candidates

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login

  Scenario: Add Candidate
    Given User is on the Recruitment Candidates page
    And User clicks on the Add button
    And User is navigated to the Add Candidate page
    And User fills the first name "Saman" and last name "Kumara" and email as "test@gmail.com"
    When User clicks the submit button
    Then User is directed to the view candidate page
    Then User can see candidate "Saman" "Kumara"

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

  Scenario: Search Candidate
    Given User is on the Recruitment Candidates page
    And User clicks on the Add button
    And User is navigated to the Add Candidate page
    And User fills the first name "Nuwa333" and last name "Kum333" and email as "nuwa333@gmail.com"
    When User clicks the submit button
    Then User is directed to the view candidate page
    Then User can see candidate "Nuwa333" "Kum333"
    Given User is on the Recruitment Candidates page
    When User types "Nuwa333 Kum333" in the search box
    Then User see the "Nuwa333" "Kum333" dropdown item
    And User clicks the dropdown item "Nuwa333" "Kum333"
    When User clicks the Search button
    Then User can see only "Nuwa333" "Kum333" in Candidates table
