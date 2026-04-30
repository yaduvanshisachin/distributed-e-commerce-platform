package com.yadav.product.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductPurchaseResponse(
        Long productId,

        String name,

        String description,

        BigDecimal price,

        double quantity
) {
}
