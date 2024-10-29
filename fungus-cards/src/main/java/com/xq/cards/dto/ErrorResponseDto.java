package com.xq.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(name = "Error response")
@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(example = "uri=/api/cards/update", description = "API path invoked by client")
    private String apiPath;

    @Schema(example = "NOT_FOUND", description = "Error code representing the error")
    private HttpStatus errorCode;

    @Schema(description = "Error message returned from implementation logic", example = "Can not process task for card with phone number/card number")
    private String errorMessage;

    @Schema(description = "Date time when error occur", example = "2024-08-25T22:30:44.173049")
    private LocalDateTime errorTime;
}
