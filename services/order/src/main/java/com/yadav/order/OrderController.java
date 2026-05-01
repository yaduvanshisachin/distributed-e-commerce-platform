package com.yadav.order;

import com.yadav.order.dto.OrderRequest;
import com.yadav.order.dto.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
    ){
        return ResponseEntity.ok(service.createOrder(request));
    }


}
