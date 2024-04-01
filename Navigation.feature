Feature: Verify contact us form functionality on website

  Background:
    Given I visit website
     When  I click on the Contact Us button
    Then I should be directed to the Contact Us page

  Scenario: Verify form validation with invalid data
    When I fill the form with the following invalid data:
      | Field        | Value            | Expected Error Message     |
      | First Name   | Xenon 1234       | First name is not valid    |
      | Last Name    | Stack 938        | Last name is not valid     |
      | Business     | 12@gmail         | Please enter valid business id |
      | Email Id     | .com             | Please enter valid email id |
      | Company      | ABCD $%$#%%^&    | Please enter valid company |
      | Phone        | ap9876544        | Phone no. is not valid     |
    Then I should see corresponding error messages
    And the form submission should fail

  Scenario: Verify form validation with valid data
    When I fill the form with valid data
      | Field        | Value            |
      | First Name   | Xenon            |
      | Last Name    | Stack            |
      | Business     | valid@email.com  |
      | Email Id     | valid@email.com  |
      | Company      | ABCD             |
      | Phone        | 1234567890       |
    Then the form submission should succeed

  Scenario: Verify form submission with empty fields
    When I attempt to submit the form without filling any fields
    Then I should see an error message prompting to fill in all the fields
    And the form submission should fail
