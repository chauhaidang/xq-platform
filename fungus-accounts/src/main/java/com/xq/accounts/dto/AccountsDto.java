package com.xq.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Accounts")
public class AccountsDto {

    @Schema(description = "Customer account number - number", example = "1078747343")
    @NotEmpty(message = "AccountNumber can not be null or empty")
    @Pattern(regexp = "^$|([0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(description = "Customer account type - string", example = "Savings|HomeLoan|Transaction|Visa")
    @NotEmpty(message = "AccountType can not be null or empty")
    private String accountType;

    @Schema(description = "Customer account branch address - string", example = "123 Bourke Street")
    @NotEmpty(message = "BranchAddress can not be null or empty")
    private String branchAddress;
}
