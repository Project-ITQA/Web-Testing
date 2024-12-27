Feature: Manage Buzz
  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login
    Given user is on buzz page

  Scenario: Add a post
    When user types "this is a new post for testing on 8191227" on post input field
    And user clicks on the post button
    Then user can see the post with content "this is a new post for testing on 8191227"

  Scenario: Add a comment to a post
    When user types "this is a new post for testing on 8423455" on post input field
    And user clicks on the post button
    Then user can see the post with content "this is a new post for testing on 8423455"
    When user clicks on the comment button of the post with content "this is a new post for testing on 8423455"
    And user types the comment "Nice work" and Enter for the post "this is a new post for testing on 8423455"
    Then user can see the comment "Nice work" for the post "this is a new post for testing on 8423455"

  Scenario: delete a post
    When user types "post to be deleted" on post input field
    And user clicks on the post button
    Then user can see the post with content "post to be deleted"
    And user clicks the options button of the post "post to be deleted"
    When user clicks the delete button
    Then user can't see the post with the content "post to be deleted"

