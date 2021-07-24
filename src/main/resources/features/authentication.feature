Feature: As a user, I want to be able to check if all authentication actions work as expected

  Scenario:  Authentication with valid username and password
    Given That I am a logged in user with "test" as username and "1234" as password
    When I retrieve my authentication credentials
    Then I should be able to check that my authentication credentials are valid

  Scenario: Logout user
    Given That I am a logged in user with "testLogout" as username and "1234" as password
    When I logout
    Then I should receive an unauthorized response