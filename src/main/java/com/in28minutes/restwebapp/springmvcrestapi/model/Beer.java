package com.in28minutes.restwebapp.springmvcrestapi.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Data
public class Beer {
    private UUID id;


    @NotNull(message = "Version cannot be null.")
    private Integer version;

    @NotNull(message = "Beer Name cannot be null.")
    @Min(value = 2, message = "Minimum beer name should be 2 chars long.")
    @Max(value = 15 , message = "Maximum beer name should be 15 chars long")
    private String beerName;

    @NotNull(message = "UPC cannot be null.")
    private String upc;

    @NotNull(message = "Quantity cannot be null.")
    private Integer quantityOnHand;

    @NotNull(message = "Price cannot be null.")
    private BigDecimal price;


    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}