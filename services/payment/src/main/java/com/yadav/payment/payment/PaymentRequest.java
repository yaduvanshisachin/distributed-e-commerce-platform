package com.yadav.payment.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,

        BigDecimal amount,

        PaymentMethod paymentMethod,

        Integer OrderId,

        String orderReference,

        Customer customer
) {
}
