package com.xq.testplan.component.requirement;

import com.intuit.karate.JsonUtils;
import com.intuit.karate.Match;
import com.xq.Config;
import com.xq.ConfigReader;
import com.xq.testplan.api.client.RestApisTestPlanApi;
import com.xq.testplan.api.invoker.ApiClient;
import com.xq.testplan.api.invoker.ApiException;
import com.xq.testplan.api.invoker.Configuration;
import com.xq.testplan.api.model.Requirement;
import com.xq.testplan.api.model.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.xq.StringUtility.generateRandomString;

public class RequirementApiTest {
    private static final ApiClient apiClient = Configuration.getDefaultApiClient();
    private static RestApisTestPlanApi testPlanApi = null;

    @BeforeAll
    static void setup() throws ApiException {
        apiClient.updateBaseUri(new ConfigReader().loadConfig().getApiGateway());
        testPlanApi = new RestApisTestPlanApi(apiClient);
        testPlanApi.deleteAllRequirements();
    }

    @Test
    void testCreateARequirement() throws ApiException {
        Requirement newRequirement = generateARequirement();

        Response res = testPlanApi.createRequirement(newRequirement);
        Match.that(JsonUtils.toJson(res))
                .isEqualTo("{statusCode: '201', statusMsg: 'Requirement created', uuid: '#notnull'}");

        var requirementRes = testPlanApi.fetchRequirementWithHttpInfo(res.getUuid());
        Match.that(requirementRes.getStatusCode()).isEqualTo(200);
        Match.that(requirementRes.getData()).isEqualTo(newRequirement);

        var requirementListRes = testPlanApi.getAllRequirementsWithHttpInfo();
        Match.that(requirementListRes.getStatusCode()).isEqualTo(200);
        Match.that(requirementListRes.getData().getTotal()).isEqualTo(1);
    }

    @Test
    void testCreateMultipleTestRequirement() throws ApiException {
        for (int i = 0; i < 3; i++) {
            var requirement = generateARequirement().title(generateRandomString(20) + i);
            testPlanApi.createRequirement(requirement);
        }

        Match.that(testPlanApi.getAllRequirements().getTotal() >= 3).isEqualTo(true);
    }


    private Requirement generateARequirement() {
        return new Requirement()
                .title(generateRandomString(20))
                .description(generateRandomString(30))
                .scopes("scope1,scope2")
                .tags("tag1,tag2")
                .references("http://www.google.com");
    }
}
