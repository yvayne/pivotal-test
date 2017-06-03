Feature: Story Task

  Background:
    Given I request POST "/projects" with:
      | name | projects2 |
    And I stored project
    And I request POST "/projects/[Project1.id]/stories" with:
      | name | storie2 |
    And I stored storie

  Scenario: Post new task
    When I request POST "/projects/[Project1.id]/stories/[Story1.id]/tasks" with:
      | project_id  | 2037413     |
      | story_id    | #146480817  |
      | description | My new Task |
      | complete    | true        |
      | position    | 1           |
    Then I expect status code 404

  Scenario: Get the story task created
    When I request GET "/projects/[Project1.id]/stories/[Story1.id]/tasks"
    Then I expect status code 404
    Then The task should be successful

