package com.yadav.order.kafka;

import com.yadav.order.customer.CustomerResponse;
import com.yadav.order.order.PaymentMethod;
import com.yadav.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}