package com.xq.testplan.controller;

import com.xq.testplan.constants.TestPlanConstants;
import com.xq.testplan.dto.RequirementsDto;
import com.xq.testplan.dto.ErrorResponseDto;
import com.xq.testplan.dto.ResponseDto;
import com.xq.testplan.service.IRequirementsService;
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
        name = "REST APIS  TestPlan",
        description = "REST APIS for TestPlan service"
)
@RestController
@RequestMapping(path = "/api/requirement", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
@Validated
public class RequirementsController {
    IRequirementsService requirementsService;

    @PostMapping("/create")
    @Operation(
            summary = "Create a test requirement",
            description = "API endpoint to create a test requirement information by input request"
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
    public ResponseEntity<ResponseDto> createRequirement(@Valid @RequestBody RequirementsDto requirementsDto) {
        log.info("Request received to create test requirement for customer: {}", requirementsDto.toString());
        String uuid = requirementsService.createRequirement(requirementsDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseDto.builder()
                        .statusCode(TestPlanConstants.STATUS_201)
                        .statusMsg(TestPlanConstants.MSG_201)
                        .uuid(uuid)
                        .build());
    }

    @GetMapping("/{uuid}")
    @Operation(
            summary = "Get a test requirement",
            description = "API endpoint to get a test requirement information by uuid"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status success"
            )
    })
    public ResponseEntity<RequirementsDto> fetchAccount(
            @PathVariable("uuid") @Pattern(
                    regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[4][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$",
                    message = "requirement uuid must be a valid UUID"
            ) String uuid
    ) {
        log.info("Request received to fetch test requirement details with uuid: {}", uuid);
        RequirementsDto requirementsDto = requirementsService.fetchRequirement(uuid);
        return ResponseEntity.ok(requirementsDto);
    }

    @PutMapping("/update")
    @Operation(
            summary = "Update a test requirement",
            description = "API endpoint to update a test requirement by input request"
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
                    description = "Http status internal server error - can not update a test requirement",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateAccount(
            @RequestParam @Pattern(
                    regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[4][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$",
                    message = "requirement uuid must be a valid UUID"
            ) String uuid,
            @Valid @RequestBody RequirementsDto requirementsDto
    ) {
        log.info("Request received to update test requirement with uuid: {}", uuid);
        boolean isUpdated = requirementsService.updateRequirement(uuid, requirementsDto);
        return isUpdated ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(ResponseDto.builder()
                                .statusCode(TestPlanConstants.STATUS_200)
                                .statusMsg(TestPlanConstants.MSG_200)
                                .build()) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(ResponseDto.builder()
                                .statusCode(TestPlanConstants.STATUS_417)
                                .statusMsg(TestPlanConstants.MSG_417_UPDATE)
                                .build());
    }

    @Operation(
            summary = "Delete a test requirement",
            description = "API endpoint to delete a test requirement by uuid"
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
                    description = "Http status internal server error - can not delete a test requirement",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam @Pattern(
                    regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[4][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$",
                    message = "requirement uuid must be a valid UUID"
            ) String uuid
    ) {
        log.info("Request received to delete test requirement details for uuid: {}", uuid);
        boolean isDeleted = requirementsService.deleteRequirement(uuid);
        return isDeleted ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(ResponseDto.builder()
                                .statusCode(TestPlanConstants.STATUS_200)
                                .statusMsg(TestPlanConstants.MSG_DEL_REQ_SUCCESS)
                                .build()):
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(ResponseDto.builder()
                                .statusCode(TestPlanConstants.STATUS_417)
                                .statusMsg(TestPlanConstants.MSG_417_DELETE)
                                .build());    }
}
