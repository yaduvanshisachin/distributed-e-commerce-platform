package com.yadav.order;

import com.yadav.order.customer.CustomerClient;
import com.yadav.order.dto.OrderMapper;
import com.yadav.order.dto.OrderRequest;
import com.yadav.order.exception.BusinessException;
import com.yadav.order.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;

    public Integer createOrder(OrderRequest request){
         //check the customer --> customer-ms (open Feign)
        var customer = this.customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer found with provided id"));

        this.productClient.purchaseProduct(request.getProducts());
        var order = this.repository.save(mapper.toOrder(request));
        //purchase the products --> product-ms (RestTemplate)

        //persist Order

        //persist order lines

        //start payment process

        //send the order confirmation --> notification-ms(kafka)
    }
}
