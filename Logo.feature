Feature: Verify homepage loads on clicking logo

  Scenario: Clicking on the logo should load the homepage
    Given the user is on the home
    When the user clicks on the logo
    Then the homepage should be loaded
