Feature: Test Requirements API

  Background:
    And def randomTitle =
      """
      function(max){ return "title-" + Math.floor(Math.random() * max) }
      """
    * def ApiClient = Java.type('com.xq.testplan.api.invoker.ApiClient')
    * def Configuration = Java.type('com.xq.testplan.api.invoker.Configuration')
    * def KarateRestApisTestPlanApi = Java.type('com.xq.testplan.api.client.KarateRestApisTestPlanApi')
    * def ConfigReader = Java.type('com.xq.ConfigReader')

    # Initialize API client
    * def apiClient = Configuration.getDefaultApiClient()
    * def config = new ConfigReader().loadConfig()
    * apiClient.updateBaseUri(config.getApiGateway())
    * def testPlanApi = new KarateRestApisTestPlanApi(apiClient)

  Scenario: Create a e2e using direct JSON
    Given def requirement =
      """
      {
        title: "#(randomTitle(100))",
        description: 'Test Description',
        scopes: 'scope1,scope2',
        tags: 'tag1,tag2',
        references: 'http://www.google.com'
      }
      """
    When def userCreateRequirement = testPlanApi.createRequirement(requirement)
    Then match userCreateRequirement == { statusCode: "201", statusMsg: "#string", uuid: "#string" }
    When def userFetchRequirement = testPlanApi.fetchRequirementToString(userCreateRequirement.uuid)
    Then match userFetchRequirement == requirement
