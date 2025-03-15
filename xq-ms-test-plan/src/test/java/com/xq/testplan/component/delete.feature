Feature: delete

  Scenario: delete all requirements
    Given url 'http://localhost:8080'
    And path 'api/requirement/delete/all'
    When method delete
    Then status 200