Feature: Account

  Scenario: Retrieve user's accounts using the Pivotal Tracker API.

    When I do a GET request to "/accounts"

    Then I expect a 200 status code.
