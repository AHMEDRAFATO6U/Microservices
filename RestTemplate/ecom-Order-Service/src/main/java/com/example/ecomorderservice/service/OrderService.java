package com.example.ecomorderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RestTemplate restTemplate;
    public String palceOrder(String productId) {
        String response = restTemplate.getForObject(
                "http://localhost:8081/Inventory/"+productId ,
                String.class
        );
        return "IN STOCK" .equals(response) ?
                "ORDER PLACED SUCCESSFULLY" :
                "ORDER OUT OF STOCK";
    }
}
