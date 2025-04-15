/*
 * TestPlan microservice
 * TestPlan microservice api documentation
 *
 * The version of the OpenAPI document: v1
 * Contact: service.testplan@xq.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.xq.testplan.api.invoker;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-16T01:01:53.229700+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class Configuration {
    public static final String VERSION = "v1";

    private static volatile ApiClient defaultApiClient = new ApiClient();

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static ApiClient getDefaultApiClient() {
        return defaultApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setDefaultApiClient(ApiClient apiClient) {
        defaultApiClient = apiClient;
    }
}
