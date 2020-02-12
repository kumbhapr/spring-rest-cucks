Feature: Dashboard API Test
  
  Scenario: Test success response from API
    Given I have base URL for user API
    And I use user list API
    When I make HTTP request
    Then I get OK response
    And response contains json
    
  
  Scenario: Test failure response from API
    Given I have base URL for user API
    And I use wrong API path
    When I make HTTP request
    Then I get 404 response
    