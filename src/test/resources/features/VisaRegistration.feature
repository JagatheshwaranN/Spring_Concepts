Feature: Visa Registration Functionality

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
      | keyword     | count |
      | Spring Boot | 5     |
      | Selenium    | 3     |
      | Java        | 2     |