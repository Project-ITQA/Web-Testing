Feature: Add Candidate

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page

  Scenario: Add Candidate after filling all mandatory fields
    Given User is on the Recruitment Candidates page
    And User clicks on the Add button
    And User is navigated to the Add Candidate page
    And User fills the first name "Saman" and last name "Kumara" and email as "test@gmail.com"
    When User clicks the submit button
    Then User is directed to the view candidate page
    Then User can see candidate "Saman" "Kumara"

  Scenario: Add Candidate without filling mandatory fields
    Given User is on the Recruitment Candidates page
    And User clicks on the Add button
    And User is navigated to the Add Candidate page
    And User fills the first name "Saman" and last name "Kumara"
    When User clicks the submit button
    Then User can see the required message under the email field