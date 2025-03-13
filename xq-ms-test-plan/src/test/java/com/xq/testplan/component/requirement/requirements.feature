Feature: Test Requirements API

  Background:
    Given url 'http://localhost:8080'
    And def randomTitle =
      """
      function(max){ return "title-" + Math.floor(Math.random() * max) }
      """
    And call read('classpath:com/xq/testplan/component/delete.feature')

  @progression
  Scenario: Create a test requirement
    Given path 'api/requirement/create'
    And def title = randomTitle(100)
    And request
      """
      {
        "title": "#(title)",
        "description": "test plan",
        "scopes": "scope1,scope2",
        "tags": "tag1,tag2",
        "references": "http://www.google.com"
      }
      """
    When method post
    Then status 201
    And match response.statusCode == '201'
    And match response.statusMsg == 'Requirement created'
    And match response.uuid == "#notnull"

    Given path "api/requirement/" + response.uuid
    And def uuid = response.uuid
    When method get
    Then status 200
    And match response ==
      """
      {
        "title": "#(title)",
        "description": "test plan",
        "scopes": "scope1,scope2",
        "tags": "tag1,tag2",
        "references": "http://www.google.com"
      }
      """

    Given path 'api/requirement/all'
    When method get
    Then status 200
    And match response.total == 1


