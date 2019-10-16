Feature: Test me App Login



  Scenario: Login with Valid Credentials
    Given User must be on login page
    And User must register with Application
    When user enter the username "lalitha" and user enter the password "Password123"
    And user click on login button
    Then User Navigate to home page


