package com.xq.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(name = "Cards")
public class CardDto {

    @Schema(description = "Card mobile number - string", example = "0123456789")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Card number - number", example = "107874734312")
    @NotEmpty(message = "Card number can not be null or empty")
    @Pattern(regexp = "^$|([0-9]{12})", message = "Card Number must be 12 digits")
    private String cardNumber;


    @Schema(description = "Card type - string", example = "CREDIT")
    @NotEmpty(message = "Card type can not be null or empty")
    private String cardType;


    @Schema(description = "Card limit amount - number", example = "1000")
    @Positive(message = "Card limit amount must be greater than zero")
    private int totalLimit;

    @Schema(description = "Used amount - number", example = "900")
    @PositiveOrZero(message = "Used amount must be equal or greater than zero")
    private int amountUsed;

    @Schema(description = "Available amount - number", example = "100")
    @PositiveOrZero(message = "Total available amount must be equal or greater than zero")
    private int availableAmount;
}
