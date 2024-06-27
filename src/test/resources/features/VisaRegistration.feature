Feature: Visa Registration Functionality

  @visa
  Scenario Outline: As a user, I want to register on the Visa Registration Site
    Given I am on the Visa Registration home page
    When I enter "<first_name>" and "<last_name>" on the name details section
    And I select "<from_country>" and "<to_country>" on the country details section
    And I select "<date_of_birth>" on the birth date details section
    And I type "<email>" and "<phone_number>" on the contact details section
    And I type "<comments>" on the additional comments section
    And I click on submit application button
    Then I should see the visa registration confirmation number

    Examples:
      | from_country | to_country | date_of_birth | first_name | last_name | email              | phone_number   | comments   |
      | Isle of Man  | Mali       | 2011-05-31    | Kraig      | Wiza      | Kraig@nobody.com   | 1-000-884-1373 | For Travel |
      | Lithuania    | Mexico     | 2001-01-01    | Houston    | Kertzmann | Houston@nobody.com | 284.864.6580   | For Travel |
      | Somalia      | Greece     | 2004-07-02    | Ruthie     | Stamm     | Ruthie@nobody.com  | 1-209-813-9712 | For Travel |