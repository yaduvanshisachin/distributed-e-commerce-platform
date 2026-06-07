package com.yadav.order.order;

import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request){
        return Order.builder()
                .id(request.getId())
                .customerId(request.getCustomerId())
                .paymentMethod(request.getPaymentMethod())
                .reference(request.getReference())
                .totalAmount(request.getAmount())
                .build();
    }

    public OrderResponse toOrderResponse(Order order){
        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getPaymentMethod(),
                order.getReference(),
                order.getTotalAmount()
        );
    }
}
