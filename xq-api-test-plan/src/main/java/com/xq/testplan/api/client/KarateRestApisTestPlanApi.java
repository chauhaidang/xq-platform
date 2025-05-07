package com.xq.testplan.api.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xq.testplan.api.invoker.ApiClient;
import com.xq.testplan.api.invoker.ApiException;
import com.xq.testplan.api.invoker.ApiResponse;
import com.xq.testplan.api.model.Requirement;
import com.xq.testplan.api.model.Response;

import java.util.Map;

public class KarateRestApisTestPlanApi extends RestApisTestPlanApi {
    ObjectMapper objectMapper;
    public KarateRestApisTestPlanApi(ApiClient apiClient) {
       super(apiClient);
       objectMapper = new ObjectMapper();
    }

    public Map<String, Object> createRequirement(Map<String, Object> object) throws ApiException, JsonProcessingException {
        ApiResponse<Response> localVarResponse = createRequirementWithHttpInfo(
                objectMapper.readValue(objectMapper.writeValueAsString(object), Requirement.class)
        );
        return objectMapper.readValue(objectMapper.writeValueAsString(localVarResponse.getData()), Map.class);
    }

    public Map<String, Object> createRequirementWithHttpInfo(String jsonString) throws ApiException, JsonProcessingException {
        var apiResponse = createRequirementWithHttpInfo(objectMapper.readValue(jsonString, Requirement.class));
        return objectMapper.readValue(objectMapper.writeValueAsString(apiResponse), Map.class);
    }

    public Map<String, Object> fetchRequirementToString(String uuid) throws ApiException, JsonProcessingException {
        ApiResponse<Requirement> localVarResponse = fetchRequirementWithHttpInfo(uuid);
        return objectMapper.readValue(objectMapper.writeValueAsString(localVarResponse.getData()), Map.class);
    }
}
