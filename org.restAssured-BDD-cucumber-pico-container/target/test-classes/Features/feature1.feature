Feature: get user posts
 

  Background:
  	Given uri of rest api in "DEV" environment
  	And define HTTP request
  	
  	@smoketest
  Scenario: get all posts
    Given submit request via HTTP GET method
    Then status code is 200 and Content-Type is "application/json"
    
  @smoketest
  Scenario: get specific post
  When submit request for id "10" via GET method
  Then status code is "200" and id is "10" in json response body