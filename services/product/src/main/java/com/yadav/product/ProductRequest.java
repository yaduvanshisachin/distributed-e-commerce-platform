package com.yadav.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    Long Id;

    @NotNull(message = "Product name is required")
    String name;

    @NotNull(message = "Product description is required")
    String description;

    @Positive(message = "Available Quantity")
    double availableQuantity;

    @Positive(message = "Price should be positive")
    BigDecimal price;

    @NotNull(message = "Price Category is required")
    Long categoryId;
}
