package com.yadav.order.payment;

import com.yadav.order.customer.CustomerResponse;
import com.yadav.order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,

        PaymentMethod paymentMethod,

        Integer id, String orderReference,

        CustomerResponse customer
) {
}
