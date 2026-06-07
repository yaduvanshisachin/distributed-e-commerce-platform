package com.yadav.order;

import com.yadav.order.customer.CustomerClient;
import com.yadav.order.dto.OrderMapper;
import com.yadav.order.dto.OrderRequest;
import com.yadav.order.dto.OrderResponse;
import com.yadav.order.exception.BusinessException;
import com.yadav.order.kafka.OrderConfirmation;
import com.yadav.order.kafka.OrderProducer;
import com.yadav.order.orderLine.OrderLineRequest;
import com.yadav.order.orderLine.OrderLineService;
import com.yadav.order.payment.PaymentClient;
import com.yadav.order.payment.PaymentRequest;
import com.yadav.order.product.ProductClient;
import com.yadav.order.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request){
         //check the customer --> customer-ms (open Feign)
        var customer = this.customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer found with provided id"));

        var purchasedProducts = this.productClient.purchaseProduct(request.getProducts());
        var order = this.repository.save(mapper.toOrder(request));

        for(PurchaseRequest purchaseRequest  : request.getProducts()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()

                    )
            );
        }

        //purchase the products --> product-ms (RestTemplate)

        //persist Order

        //persist order lines

        //todo start payment process
        var paymentRequest = new PaymentRequest(
                request.getAmount(),
                request.getPaymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        //send the order confirmation --> notification-ms(kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.getReference(),
                        request.getAmount(),
                        request.getPaymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id){
        return repository.findById(id)
                .map(mapper::toOrderResponse)
                .orElseThrow(() -> new BusinessException("No order found with provided id"));
    }
}
