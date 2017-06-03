Feature: Workspaces

  Background:
    Given I request POST "/my/workspaces" with:
      | name | workspacesds |
    And I stored project

  Scenario: Post Create a workspace
    When I request GET "/my/workspaces/[projectid]"
    Then I request DELETE "/my/workspaces/[projectid]"

  Scenario: List workspaces using Get
    When I request GET "/my/workspaces"
    Then I expect status code 200
    Then I request DELETE "/my/workspaces/[projectid]"






