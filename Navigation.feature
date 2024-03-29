Feature: Verify main navigation links show sub-navigation menu

  Scenario: Verify all main navigation links show sub-navigation menu
    Given the user opens the website
    When the user hovers over each main navigation link
    Then the sub-navigation menu should be displayed for each main navigation link
