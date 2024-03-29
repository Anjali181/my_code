Feature: Verify navigation to Contact Us page

  Scenario: Verify Contact Us navigates to Contact us form
    Given the user is on the homepage
    When the user clicks on the CONTACT US button
    Then the user should be navigated to the contact-us page
