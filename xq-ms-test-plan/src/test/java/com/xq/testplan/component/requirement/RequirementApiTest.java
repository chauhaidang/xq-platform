package com.xq.testplan.component.requirement;

import com.intuit.karate.Json;
import com.intuit.karate.JsonUtils;
import com.intuit.karate.Match;
import com.intuit.karate.StringUtils;
import com.xq.testplan.api.client.RestApisTestPlanApi;
import com.xq.testplan.api.invoker.ApiClient;
import com.xq.testplan.api.invoker.ApiException;
import com.xq.testplan.api.invoker.Configuration;
import com.xq.testplan.api.invoker.JSON;
import com.xq.testplan.api.model.Requirement;
import com.xq.testplan.api.model.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.xq.StringUtility.generateRandomString;

public class RequirementApiTest {
    private static final ApiClient apiClient = Configuration.getDefaultApiClient();
    @BeforeAll
    static void setup() {
        apiClient.updateBaseUri("http://localhost:8080");
    }
    @Test
    void testA() throws ApiException {

        Requirement req = new Requirement()
                .title(generateRandomString(20))
                .description(generateRandomString(30))
                .scopes("scope1,scope2")
                .tags("tag1,tag2")
                .references("http://www.google.com");

        Response res = new RestApisTestPlanApi(apiClient).createRequirement(req);
        Match.that(JsonUtils.toJson(res)).isEqualTo("{statusCode: '201', statusMsg: 'Requirement created', uuid: '#notnull'}");
    }
}
