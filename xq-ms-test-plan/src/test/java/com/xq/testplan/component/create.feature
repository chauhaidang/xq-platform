Feature: create

  Scenario: create a test requirement
    Given url 'http://localhost:8080'
    And path 'api/requirement/create'
    And request __arg
    When method post
    Then status 201