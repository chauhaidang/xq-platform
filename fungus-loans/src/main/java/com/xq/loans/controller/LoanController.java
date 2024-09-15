package com.xq.loans.controller;

import com.xq.loans.dto.ErrorResponseDto;
import com.xq.loans.dto.LoanDto;
import com.xq.loans.dto.ResponseDto;
import com.xq.loans.service.ILoanService;
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
        name = "REST APIS for Loans",
        description = "REST APIS for Loan service"
)
@RestController
@RequestMapping(path = "/api/loans", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
@Validated
public class LoanController {
    private ILoanService loanService;

    @PostMapping("/create")
    @Operation(
            summary = "Create a loan",
            description = "API endpoint to create a loan information by input loan request"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http status created",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status internal server error - can not create a loan",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> createLoan(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            String mobileNumber) {
        log.info("Request received to create loan by mobileNumber: {}", mobileNumber); loanService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("201", "Loan successfully created"));
    }


    @GetMapping("/fetch")
    @Operation(
            summary = "Get a loan",
            description = "API endpoint to get a loan information by mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status success"
            )
    })
    public ResponseEntity<LoanDto> fetchLoan(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits") String mobileNumber
    ) {
        log.info("Request received to fetch loan detail for mobile number: {}", mobileNumber);
        LoanDto loanDto = loanService.fetchLoan(mobileNumber);
        return ResponseEntity.ok(loanDto);
    }

    @PutMapping("/update")
    @Operation(
            summary = "Update an loan",
            description = "API endpoint to update an loan by input loan request"
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
                    description = "Http status internal server error - can not update an loan",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody LoanDto loanDto) {
        log.info("Request received to update loan details for customer with mobileNumber: {}",
                loanDto.getMobileNumber());
        boolean isUpdated = loanService.updateLoan(loanDto);
        return isUpdated ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto("200", "Loan successfully updated")) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto("417", "Fail to update loan"));
    }

    @Operation(
            summary = "Delete a loan",
            description = "API endpoint to delete a loan by mobile number"
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
                    description = "Http status internal server error - can not delete loan",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoan(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits") String mobileNumber
    ) {
        log.info("Request received to delete loan details for mobile number: {}", mobileNumber);
        boolean isDeleted = loanService.deleteLoan(mobileNumber);
        return isDeleted ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto("200", "Loan successfully deleted")) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto("417", "Fail to delete loan"));
    }

}
