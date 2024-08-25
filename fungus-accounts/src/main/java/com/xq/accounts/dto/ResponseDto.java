package com.xq.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "Success response")
@Data @AllArgsConstructor
public class ResponseDto {
    @Schema(example = "201")
    private String statusCode;

    @Schema(example = "Account created successfully")
    private String statusMsg;
}
