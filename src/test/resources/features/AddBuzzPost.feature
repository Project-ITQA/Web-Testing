Feature: Add Buzz Post

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be on dashboard page
    Given user is on buzz page

  Scenario: Add a post
    When user types "this is a new post for testing on 8191227" on post input field
    And user clicks on the post button
    Then user can see the post with content "this is a new post for testing on 8191227"