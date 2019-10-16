Feature: Test me App Login



  Scenario Outline: Login with Valid Credentials
    Given User must be on login page
    And User must register with Application
    When user enter the username "<username>" and user enter the password "<password>"
    And user click on login button
    Then User Navigate to home page

				Examples:
				|username|password|
				|lalitha|Password123|
				|rahul123|rahul123|
