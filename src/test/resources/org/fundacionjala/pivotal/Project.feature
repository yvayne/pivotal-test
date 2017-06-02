Feature: Project

    Background:
    Given I request POST "/projects" with:
      | name | projectTest2 |
    And I stored project

  Scenario: Post Create Project
    When I request GET "/projects/[projectid]"
    Then I request DELETE "/projects/[projectid]"

  Scenario: List projects using Get
    When I request GET "/projects"
    Then I expect status code 200
    Then I request DELETE "/projects/[projectid]"

  Scenario: Get a Project
    When I request GET "/projects/[projectid]"
    Then I expect status code 200
    Then I request DELETE "/projects/[projectid]"

  Scenario: Delete Project
    Then I request DELETE "/projects/[projectid]"
    Then I expect status code 204

  Scenario: PutProject
    When I request PUT "/projects/[projectid]" with:
    | name | editedNameTest2 |
    Then I expect status code 200
    Then I request DELETE "/projects/[projectid]"







