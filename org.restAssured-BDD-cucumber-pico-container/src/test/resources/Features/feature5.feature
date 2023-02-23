Feature: post updation

  Background: 
    Given uri of rest api in "QA" environment
    And define HTTP request

  @smoketest
  Scenario: update an existing post
    When submit request for id 100 via PUT method
      | data          |
      | hi,h r u?, 10 |

  @result
  Scenario: update posts
    When submit request via PUT to service by taking data from excel file
    Then validate response as data in excel file
