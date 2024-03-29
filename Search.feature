Feature: Verify search functionality

  Scenario: Search for a keyword
    Given the user is on the homepage
    When  the user clicks on the search icon the search bar appears
    And   the user enters keyword into the search bar
    Then  the search results page should be displayed
    And  the search results should contain relevant items related to keyword
