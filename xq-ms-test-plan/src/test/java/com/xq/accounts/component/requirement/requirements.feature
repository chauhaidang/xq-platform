Feature: Test Requirements API

  Background:
    Given url apigateway
    And def randomTitle =
      """
      function(max){ return "title-" + Math.floor(Math.random() * max) }
      """
    And configure afterFeature = function(){ karate.call(domainFeaturePath + '/delete.feature'); }

  @regression
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

  @regression
  Scenario Outline: Create multiple test requirements
    * def body =
      """
      {
        title: 'title <case>',
        description: 'description <case>',
        scopes: "scope test",
        tags: "tag test",
        references: "http://www.google.com"
      }
      """
    Given path 'api/requirement/create'
    And request body
    When method post
    Then status 201
    And match response.statusCode == '201'
    And match response.statusMsg == 'Requirement created'
    And match response.uuid == "#notnull"
    And print body
    Examples:
      | case |
      | 1    |
      | 2    |
      | 3    |

  @progression
  Scenario: test connect with another feature
    Given def withBody = { title: '#(randomTitle(100))', description: 'test plan', scopes: 'scope1,scope2', tags: 'tag1,tag2', references: 'http://www.google.com' }
    When call read(domainFeaturePath + '/create.feature') withBody
    Then match response.statusCode == '201'
    And match response.statusMsg == 'Requirement created'
    And match response.uuid == "#notnull"