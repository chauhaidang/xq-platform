Feature: delete

  Background:
    Given url 'http://localhost:8080'
  Scenario: delete all requirements
    Given path 'api/requirement/delete/all'
    When method delete
    Then status 200