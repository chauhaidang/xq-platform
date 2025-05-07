Feature: Test Requirements API

  Background:
    And def randomTitle =
      """
      function(max){ return "title-" + Math.floor(Math.random() * max) }
      """
    * def ApiClient = Java.type('com.xq.testplan.api.invoker.ApiClient')
    * def Configuration = Java.type('com.xq.testplan.api.invoker.Configuration')
    * def RestApisTestPlanApi = Java.type('com.xq.testplan.api.client.RestApisTestPlanApi')
    * def Requirement = Java.type('com.xq.testplan.api.model.Requirement')
    * def ConfigReader = Java.type('com.xq.ConfigReader')

    # Initialize API client
    * def apiClient = Configuration.getDefaultApiClient()
    * def config = new ConfigReader().loadConfig()
    * apiClient.updateBaseUri(config.getApiGateway())
    * def objectMapper = apiClient.getObjectMapper()
    * def testPlanApi = new RestApisTestPlanApi(apiClient)

  Scenario: Create a e2e using direct JSON
    * def e2e =
      """
      {
        title: 'Test Title',
        description: 'Test Description',
        scopes: 'scope1,scope2',
        tags: 'tag1,tag2',
        references: 'http://www.google.com'
      }
      """
#    * string jsonString = e2e
    * def javaRequirement = objectMapper.readValue(e2e, Requirement)
    * def response = testPlanApi.createRequirement(javaRequirement)
    * match response.statusCode == '201'
    * match response.statusMsg == 'Requirement created'
    * match response.uuid == '#notnull'

