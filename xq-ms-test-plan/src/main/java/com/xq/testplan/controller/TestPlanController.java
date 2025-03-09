package com.xq.testplan.controller;

import com.xq.testplan.constants.TestPlanConstants;
import com.xq.testplan.dto.CustomerDto;
import com.xq.testplan.dto.ErrorResponseDto;
import com.xq.testplan.dto.ResponseDto;
import com.xq.testplan.service.ITestPlanService;
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
                .body(new ResponseDto(TestPlanConstants.STATUS_201, TestPlanConstants.MSG_201));
    }
} 