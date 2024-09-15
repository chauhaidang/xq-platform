package com.xq.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(name = "Loans")
public class LoanDto {

    @Schema(description = "Loan mobile number - string", example = "0123456789")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Loan number - number", example = "107874734312")
    @NotEmpty(message = "Loan number can not be null or empty")
    @Pattern(regexp = "^$|([0-9]{12})", message = "Loan Number must be 12 digits")
    private String loanNumber;


    @Schema(description = "Loan type - string", example = "HOME_LOAN")
    @NotEmpty(message = "Loan type can not be null or empty")
    private String loanType;


    @Schema(description = "Total loan amount - number", example = "1000")
    @Positive(message = "Total loan must be greater than zero")
    private int totalLoan;

    @Schema(description = "Paid amount - number", example = "900")
    @PositiveOrZero(message = "Paid amount must be equal or greater than zero")
    private int amountPaid;

    @Schema(description = "Outstanding amount - number", example = "100")
    @PositiveOrZero(message = "Total outstanding amount must be equal or greater than zero")
    private int outstandingAmount;
}
