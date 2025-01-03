Feature: Search Candidate

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: Search available Candidate
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
