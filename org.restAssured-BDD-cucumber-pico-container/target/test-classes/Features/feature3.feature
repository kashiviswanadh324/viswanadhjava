Feature: posts creation

  Scenario: 
    Given uri of rest api in "QA" environment
    And define HTTP request
    Then validate that restful service with content type as "application/json"
      | uid | title  | body                  | criteria  | sc  |
      |  10 | wishes | all the best students | unique    | 201 |
      |  10 | wishes | do signin in          | unique    | 201 |
      |  10 | wishes | do signin in          | duplicate | 201 |
      |     | wishes | do something          | wrong     | 201 |
