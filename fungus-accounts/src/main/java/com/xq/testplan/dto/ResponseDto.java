package com.xq.testplan.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "Response")
@Data @AllArgsConstructor
public class ResponseDto {
    private String statusCode;

    private String statusMsg;
}
