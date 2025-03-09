package com.xq.testplan.controller;

import com.xq.testplan.constants.AccountsContants;
import com.xq.testplan.dto.CustomerDto;
import com.xq.testplan.dto.ErrorResponseDto;
import com.xq.testplan.dto.ResponseDto;
import com.xq.testplan.service.ITestPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "REST APIS for TestPlan",
        description = "REST APIS for TestPlan service"
)
@RestController
@RequestMapping(path = "/api/testplan", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
@Validated
public class TestPlanController {
    ITestPlanService testPlanService;

    @PostMapping("/create")
    @Operation(
            summary = "Create a test plan",
            description = "API endpoint to create a test plan information by input request"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http status created",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        log.info("Request received to create test plan for customer: {}", customerDto.toString());
        testPlanService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsContants.STATUS_201, AccountsContants.MSG_201));
    }

    @GetMapping("/fetch")
    @Operation(
            summary = "Get a test plan",
            description = "API endpoint to get a test plan information by mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status success"
            )
    })
    public ResponseEntity<CustomerDto> fetchAccount(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits") String mobileNumber
    ) {
        log.info("Request received to fetch test plan details for mobile number: {}", mobileNumber);
        CustomerDto customerDto = testPlanService.fetchAccount(mobileNumber);
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("/update")
    @Operation(
            summary = "Update a test plan",
            description = "API endpoint to update a test plan by input request"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status success"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error - can not update a test plan",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        log.info("Request received to update test plan details for customer with mobileNumber: {}",
                customerDto.getAccount().getAccountNumber().toString());
        boolean isUpdated = testPlanService.updateAccount(customerDto);
        return isUpdated ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto(AccountsContants.STATUS_200, AccountsContants.MSG_200)) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto(AccountsContants.STATUS_417, AccountsContants.MSG_417_UPDATE));
    }

    @Operation(
            summary = "Delete a test plan",
            description = "API endpoint to delete a test plan by mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status success"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error - can not delete a test plan",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits") String mobileNumber
    ) {
        log.info("Request received to delete test plan details for mobile number: {}", mobileNumber);
        boolean isDeleted = testPlanService.deleteAccount(mobileNumber);
        return isDeleted ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto(AccountsContants.STATUS_200, AccountsContants.MSG_DEL_ACCOUNT_SUCCESS)) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto(AccountsContants.STATUS_417, AccountsContants.MSG_417_DELETE));
    }
}
