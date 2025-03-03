Feature: To do feature

  Background:
    * url 'http://localhost:8080/api/todos'

  @impl
  Scenario: create a todo
    * def randomTitle =
      """
      function(max){ return "title-" + Math.floor(Math.random() * max) }
      """
    * def firstTitle = randomTitle(5)

    Given request { "title": "#(firstTitle)", "completed": true }
    When method post
    Then status 200
    And match response == { "title": "#(firstTitle)", "completed": true , id: "#string"}
    * def id = response.id

    Given path id
    When method get
    Then status 200
    And match response == { "title": "#(firstTitle)", "completed": true, id: #(id) }

    * def newTitle = randomTitle(5)
    * def body =
      """
      {
        "title": "#(newTitle)",
        "completed": false
      }
      """
    And request body
    Then method post
    And status 200
    And match response.title == "#(newTitle)"

    And method get
    Then status 200
    And match response[0].title contains "#(firstTitle)"
