package com.xq.cards.controller;

import com.xq.cards.dto.ErrorResponseDto;
import com.xq.cards.dto.CardDto;
import com.xq.cards.dto.ResponseDto;
import com.xq.cards.service.ICardService;
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
        name = "REST APIS for Card",
        description = "REST APIS for Card service"
)
@RestController
@RequestMapping(path = "/api/cards", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
@AllArgsConstructor
@Validated
public class CardController {
    private ICardService cardService;

    @PostMapping("/create")
    @Operation(
            summary = "Create a card",
            description = "API endpoint to create a card information by input card request"
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
                    description = "Http status internal server error - can not create a card",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> createCard(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            String mobileNumber) {
        log.info("Request received to create card by mobileNumber: {}", mobileNumber); cardService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("201", "Card successfully created"));
    }


    @GetMapping("/fetch")
    @Operation(
            summary = "Get a card",
            description = "API endpoint to get a card information by mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status success"
            )
    })
    public ResponseEntity<CardDto> fetchCard(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits")
            String mobileNumber
    ) {
        log.info("Request received to fetch card detail for mobile number: {}", mobileNumber);
        CardDto cardDto = cardService.fetchCard(mobileNumber);
        return ResponseEntity.ok(cardDto);
    }

    @PutMapping("/update")
    @Operation(
            summary = "Update a card",
            description = "API endpoint to update a card by input card request"
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
                    description = "Http status internal server error - can not update a card",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardDto cardDto) {
        log.info("Request received to update card details for customer with mobileNumber: {}",
                cardDto.getMobileNumber());
        boolean isUpdated = cardService.updateCard(cardDto);
        return isUpdated ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto("200", "Card successfully updated")) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto("417", "Fail to update card"));
    }

    @Operation(
            summary = "Delete a card",
            description = "API endpoint to delete a card by mobile number"
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
                    description = "Http status internal server error - can not delete card",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "MobileNumber must be 10 digits")
            String mobileNumber
    ) {
        log.info("Request received to delete card details for mobile number: {}", mobileNumber);
        boolean isDeleted = cardService.deleteCard(mobileNumber);
        return isDeleted ?
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new ResponseDto("200", "Card successfully deleted")) :
                ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseDto("417", "Fail to delete card"));
    }

}
