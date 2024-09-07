package com.xq.accounts.controller;

import com.xq.accounts.constants.AccountsContants;
import com.xq.accounts.dto.CustomerDto;
import com.xq.accounts.dto.ErrorResponseDto;
import com.xq.accounts.dto.ResponseDto;
import com.xq.accounts.service.IAccountsService;
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
        name = "REST APIS for Accounts",
        description = "REST APIS for Account service"
)
@RestController
@RequestMapping(path = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
@Validated
public class AccountsController {
    IAccountsService accountService;

    @PostMapping("/create")
    @Operation(
            summary = "Create an account",
            description = "API endpoint to create an account information by input account request"
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
        log.info("Request received to create account for customer: {}", customerDto.toString());
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsContants.STATUS_201, AccountsContants.MSG_201));
    }

    @GetMapping("/fetch")
    @Operation(
            summary = "Get an account",
            description = "API endpoint to get an account information by mobile number"
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
        log.info("Request received to fetch account details for mobile number: {}", mobileNumber);
        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("/update")
    @Operation(
            summary = "Update an account",
            description = "API endpoint to update an account by input account request"
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
                    description = "Http status internal server error - can not update an account",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        log.info("Request received to update account details for customer with mobileNumber: {}",
                customerDto.getAccount().getAccountNumber().toString());
        boolean isUpdated = accountService.updateAccount(customerDto);
        return isUpdated ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto(AccountsContants.STATUS_200, AccountsContants.MSG_200)) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto(AccountsContants.STATUS_417, AccountsContants.MSG_417_UPDATE));
    }

    @Operation(
            summary = "Delete an account",
            description = "API endpoint to delete an account by mobile number"
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
                    description = "Http status internal server error - can not delete account",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits") String mobileNumber
    ) {
        log.info("Request received to delete account details for mobile number: {}", mobileNumber);
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        return isDeleted ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto(AccountsContants.STATUS_200, AccountsContants.MSG_DEL_ACCOUNT_SUCCESS)) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto(AccountsContants.STATUS_417, AccountsContants.MSG_417_DELETE));
    }
}
