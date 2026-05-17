package com.yadav.order.dto;

import com.yadav.order.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request){
        Order.builder()
                .id(request.getId())
                .customerId(request.getCustomerId())
                .paymentMethod(request.getPaymentMethod())
                .reference(request.getReference())
                .totalAmount(request.getAmount())
                .build();
    }
}
