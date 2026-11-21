package com.example.ecomorderservice.controller;

import com.example.ecomorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/Order")
@RestController
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/{productId}")
    public String PlaceOrder(@PathVariable Long productId){
    return orderService.palceOrder(productId);
    }
}
