Feature: Workspace

  Background:
    Given I request POST "/my/workspaces" with:
      | name | workspace3 |
    And I stored project

  Scenario: Get a Workspace
    When I request GET "/my/workspaces/[projectid]"
    Then I expect status code 200
    Then I request DELETE "/my/workspaces/[projectid]"

  Scenario: Delete Project
    Then I request DELETE "/my/workspaces/[projectid]"
    Then I expect status code 204





