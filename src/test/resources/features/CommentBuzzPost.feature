Feature: Comment Buzz post

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login
    Given user is on buzz page

  Scenario: Add a comment to a post
    When user types "this is a new post for testing on 8423455" on post input field
    And user clicks on the post button
    Then user can see the post with content "this is a new post for testing on 8423455"
    When user clicks on the comment button of the post with content "this is a new post for testing on 8423455"
    And user types the comment "Nice work" and Enter for the post "this is a new post for testing on 8423455"
    Then user can see the comment "Nice work" for the post "this is a new post for testing on 8423455"



