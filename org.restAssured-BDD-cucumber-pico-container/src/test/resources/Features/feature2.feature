Feature: create post

  Background: 
    Given uri of rest api in "QA" environment
    And define HTTP request

  @realtest
  Scenario Outline: get specific post in data driven
    When submit request for id "<id>" via GET method
    Then status code is "<sc>" as per "<criteria>" in json response body

    Examples: 
      | id  | criteria | sc  |
      |  10 | valid    | 200 |
      | 101 | invalid  | 404 |
      |     | blank    | 400 |

  Scenario Outline: create a new post
    When submit request via POST with
      """
        {
         "userId":<uid>,
         "title":"<title>",
         "body":"<body>"
        }
      """
    Then status code is "<sc>" as per "<criteria>" and content type is "application/json"

    @smoketest
    Examples: 
      | uid | title  | body                     | criteria  | sc  |
      |  10 | wishes | do signin in haven...boy | unique    | 201 |
      |  10 | wishes | do signin in haven...boy | duplicate | 200 |
      |     | wishes |                          | wrong     | 500 |
