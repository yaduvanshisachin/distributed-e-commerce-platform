package com.yadav.order.dto;

import com.yadav.order.entity.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        String customerId,
        PaymentMethod paymentMethod,
        String reference,
        BigDecimal amount
) {
}