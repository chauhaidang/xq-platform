function fn(config) {
    let Configuration = Java.type('com.xq.testplan.api.invoker.Configuration');
    let RestApisTestPlanApi = Java.type('com.xq.testplan.api.client.RestApisTestPlanApi');

    let apiClient = Configuration.getDefaultApiClient();
    apiClient.updateBaseUri(config.apiGateway);

    return {
        testPlan: new RestApisTestPlanApi(apiClient)
    };
}