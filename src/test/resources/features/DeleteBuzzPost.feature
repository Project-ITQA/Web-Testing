Feature: Delete Buzz Post

  Background:
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login
    Given user is on buzz page

  Scenario: delete a post
    When user types "post to be deleted" on post input field
    And user clicks on the post button
    Then user can see the post with content "post to be deleted"
    And user clicks the options button of the post "post to be deleted"
    When user clicks the delete button
    Then user can't see the post with the content "post to be deleted"