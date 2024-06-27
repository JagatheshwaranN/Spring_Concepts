Feature: Google Search Functionality

  @google
  Scenario Outline: As a user, I want to search on the google site
    Given I am on the google home page
    When I type "<keyword>" and click on search button
    Then I should see at least <count> search results

    Examples:
      | keyword     | count |
      | Spring Boot | 5     |
      | Selenium    | 3     |
      | Java        | 50    |