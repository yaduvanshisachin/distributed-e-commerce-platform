package com.yadav.payment.payment;

public class PaymentMapper {

    public Payment toPayment(PaymentRequest request){
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.OrderId())
                .build();
    }
}
