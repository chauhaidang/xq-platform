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

package com.xq.testplan.api.client;

import com.xq.testplan.api.invoker.ApiClient;
import com.xq.testplan.api.invoker.ApiException;
import com.xq.testplan.api.invoker.ApiResponse;
import com.xq.testplan.api.invoker.Configuration;
import com.xq.testplan.api.invoker.Pair;

import com.xq.testplan.api.model.ErrorResponse;
import com.xq.testplan.api.model.ListRequirementsDto;
import com.xq.testplan.api.model.Requirement;
import com.xq.testplan.api.model.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-16T00:35:51.082085+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.12.0")
public class RestApisTestPlanApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public RestApisTestPlanApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RestApisTestPlanApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Create a test requirement
   * API endpoint to create a test requirement information by input request
   * @param requirement  (required)
   * @return Response
   * @throws ApiException if fails to make API call
   */
  public Response createRequirement(Requirement requirement) throws ApiException {
    ApiResponse<Response> localVarResponse = createRequirementWithHttpInfo(requirement);
    return localVarResponse.getData();
  }

  /**
   * Create a test requirement
   * API endpoint to create a test requirement information by input request
   * @param requirement  (required)
   * @return ApiResponse&lt;Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Response> createRequirementWithHttpInfo(Requirement requirement) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = createRequirementRequestBuilder(requirement);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("createRequirement", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<Response>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<Response>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<Response>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder createRequirementRequestBuilder(Requirement requirement) throws ApiException {
    // verify the required parameter 'requirement' is set
    if (requirement == null) {
      throw new ApiException(400, "Missing the required parameter 'requirement' when calling createRequirement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/requirement/create";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(requirement);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Delete a test requirement
   * API endpoint to delete a test requirement by uuid
   * @param uuid  (required)
   * @return Response
   * @throws ApiException if fails to make API call
   */
  public Response deleteAccount(String uuid) throws ApiException {
    ApiResponse<Response> localVarResponse = deleteAccountWithHttpInfo(uuid);
    return localVarResponse.getData();
  }

  /**
   * Delete a test requirement
   * API endpoint to delete a test requirement by uuid
   * @param uuid  (required)
   * @return ApiResponse&lt;Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Response> deleteAccountWithHttpInfo(String uuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteAccountRequestBuilder(uuid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteAccount", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<Response>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<Response>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<Response>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteAccountRequestBuilder(String uuid) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling deleteAccount");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/requirement/delete";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "uuid";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("uuid", uuid));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Delete all test requirements
   * API endpoint to delete all test requirements
   * @return Response
   * @throws ApiException if fails to make API call
   */
  public Response deleteAllRequirements() throws ApiException {
    ApiResponse<Response> localVarResponse = deleteAllRequirementsWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Delete all test requirements
   * API endpoint to delete all test requirements
   * @return ApiResponse&lt;Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Response> deleteAllRequirementsWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteAllRequirementsRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteAllRequirements", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<Response>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<Response>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<Response>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteAllRequirementsRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/requirement/delete/all";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Get a test requirement
   * API endpoint to get a test requirement information by uuid
   * @param uuid  (required)
   * @return Requirement
   * @throws ApiException if fails to make API call
   */
  public Requirement fetchAccount(String uuid) throws ApiException {
    ApiResponse<Requirement> localVarResponse = fetchAccountWithHttpInfo(uuid);
    return localVarResponse.getData();
  }

  /**
   * Get a test requirement
   * API endpoint to get a test requirement information by uuid
   * @param uuid  (required)
   * @return ApiResponse&lt;Requirement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Requirement> fetchAccountWithHttpInfo(String uuid) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = fetchAccountRequestBuilder(uuid);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("fetchAccount", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<Requirement>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<Requirement>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<Requirement>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder fetchAccountRequestBuilder(String uuid) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling fetchAccount");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/requirement/{uuid}"
        .replace("{uuid}", ApiClient.urlEncode(uuid.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Get all test requirements
   * API endpoint to get all test requirements
   * @return ListRequirementsDto
   * @throws ApiException if fails to make API call
   */
  public ListRequirementsDto getAllRequirements() throws ApiException {
    ApiResponse<ListRequirementsDto> localVarResponse = getAllRequirementsWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Get all test requirements
   * API endpoint to get all test requirements
   * @return ApiResponse&lt;ListRequirementsDto&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ListRequirementsDto> getAllRequirementsWithHttpInfo() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllRequirementsRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllRequirements", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<ListRequirementsDto>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<ListRequirementsDto>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<ListRequirementsDto>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAllRequirementsRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/requirement/all";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Update a test requirement
   * API endpoint to update a test requirement by input request
   * @param uuid  (required)
   * @param requirement  (required)
   * @return Response
   * @throws ApiException if fails to make API call
   */
  public Response updateAccount(String uuid, Requirement requirement) throws ApiException {
    ApiResponse<Response> localVarResponse = updateAccountWithHttpInfo(uuid, requirement);
    return localVarResponse.getData();
  }

  /**
   * Update a test requirement
   * API endpoint to update a test requirement by input request
   * @param uuid  (required)
   * @param requirement  (required)
   * @return ApiResponse&lt;Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Response> updateAccountWithHttpInfo(String uuid, Requirement requirement) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = updateAccountRequestBuilder(uuid, requirement);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("updateAccount", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<Response>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<Response>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<Response>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder updateAccountRequestBuilder(String uuid, Requirement requirement) throws ApiException {
    // verify the required parameter 'uuid' is set
    if (uuid == null) {
      throw new ApiException(400, "Missing the required parameter 'uuid' when calling updateAccount");
    }
    // verify the required parameter 'requirement' is set
    if (requirement == null) {
      throw new ApiException(400, "Missing the required parameter 'requirement' when calling updateAccount");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/requirement/update";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "uuid";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("uuid", uuid));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(requirement);
      localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

}
