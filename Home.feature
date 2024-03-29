Feature: Verify homepage loading

  Scenario: User visits the homepage
    Given the user opens the browser
    When the user navigates to the homepage
    Then the homepage should load successfully
