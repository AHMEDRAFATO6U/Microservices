package com.example.ecomorderservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RestTemplate restTemplate;
    public String placeOrder(String productId) {

        String response = restTemplate.getForObject(
                "http://localhost:8081/Inventory/"+productId,
                String.class
        );


        return "INSTOCK" .equals(response)? "Order Placed Successfully"
                :"PRODUCT OUT OF STOCK";
    }
}
