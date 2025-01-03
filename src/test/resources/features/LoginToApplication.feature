Feature: Login to application

  Scenario: Login with valid credentials
    Given user is on home page
    When user enters "Admin" as username
    And user enters "admin123" as password
    Then user should be able to login
