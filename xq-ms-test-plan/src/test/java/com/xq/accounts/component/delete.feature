Feature: delete

  Scenario: delete all requirements
    Given url apigateway
    And path 'api/requirement/delete/all'
    When method delete
    Then status 200