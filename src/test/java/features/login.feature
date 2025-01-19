Feature: Login to Sample App
  As a user
  I want to log in to the Sample App
  So that I can see the welcome message

  Scenario: Successful login with valid credentials
    When I click on the Sample App
    Then the Sample App page is displayed
    When I enter a random username in the "Jasmine" field
    And I enter "pwd" in the Password field
    And I click on the Login button
    Then a success message is displayed at the top of the page