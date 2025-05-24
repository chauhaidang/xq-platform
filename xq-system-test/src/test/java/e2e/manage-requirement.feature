Feature: Test Requirements API

  Background:
    * def randomTitle =
      """
      function(max){ return "title-" + Math.floor(Math.random() * max) }
      """
    * def testPlan = apis.testPlan
    * def Requirement = models.Requirement

  Scenario: User create and view requirement
    Given def requirement =
      """
      {
        title: "#(randomTitle(1000))",
        description: 'Test Description',
        scopes: 'scope1,scope2',
        tags: 'tag1,tag2',
        references: 'http://www.google.com'
      }
      """
    When def userCreateRequirement = testPlan.createRequirement(karate.toBean(requirement, Requirement))
    Then match karate.toJson(userCreateRequirement) == { statusCode: "201", statusMsg: "#string", uuid: "#string" }
    When def userFetchRequirement = testPlan.fetchRequirement(userCreateRequirement.uuid)
    Then match karate.toJson(userFetchRequirement) == requirement
