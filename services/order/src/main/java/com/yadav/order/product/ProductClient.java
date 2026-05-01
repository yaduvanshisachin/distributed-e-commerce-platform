package com.yadav.order.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> requestBody){

    }
}
